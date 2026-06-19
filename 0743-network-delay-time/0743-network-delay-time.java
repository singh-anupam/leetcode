class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int arr[] = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[k]=0;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k,0});
        while(q.size()>0){
            int rm[] = q.poll();
            int t = rm[1];
            for(int nbr[] : graph.get(rm[0])){
                if(t+nbr[1]<arr[nbr[0]]){
                    q.offer(new int[]{nbr[0],t+nbr[1]});
                    arr[nbr[0]]=t+nbr[1];
                }
            }
        }
        int ans = 0;

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==Integer.MAX_VALUE)
                return -1;
            ans = Math.max(arr[i],ans);
        }

        return ans;



        
    }
}