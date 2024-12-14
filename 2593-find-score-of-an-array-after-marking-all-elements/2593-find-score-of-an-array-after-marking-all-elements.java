class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean vis[] = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }

        while(pq.size()>0){
            int rm[] = pq.poll();
            if(vis[rm[1]])
            continue;
            vis[rm[1]]=true;
            int left = rm[1]-1<0?0:rm[1]-1;
            int right = rm[1]+1>=nums.length?nums.length-1:rm[1]+1;
            vis[left]=true;
            vis[right]=true;
            score+=rm[0];
        }
        return score;
      
        
    }
}