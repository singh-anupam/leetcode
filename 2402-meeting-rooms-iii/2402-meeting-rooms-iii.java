class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b)->a[0]==b[0]?Long.compare(a[1],b[1]):Long.compare(a[0],b[0]));

        for(int i=0;i<n;i++){
            free.offer(i);
        }

        int count[] = new int[n];

        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            int diff = end-start;
            while(busy.size()>0 && busy.peek()[0]<=start){
                long rm[] = busy.poll();
                free.offer((int)rm[1]);
            }
            if(free.size()>0){
            int rm = free.poll();
            count[rm]++;
            busy.offer(new long[]{end,rm});
            }else{
                long rm[] = busy.poll();
                busy.offer(new long[]{rm[0]+diff,rm[1]});
                count[(int)rm[1]]++;
            }
        }

        int max =0;
        int ans = 0;

        for(int i=0;i<n;i++){
            // System.out.println(count[i]);
            if(count[i]>max)
            {
                ans=i;
                max = count[i];
            }
        }

        return ans;
        
    }
}