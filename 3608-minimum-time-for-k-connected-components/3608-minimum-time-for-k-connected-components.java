class Solution {
    public int minTime(int n, int[][] edges, int k) {
        int indegree[] = new int[n];
         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int edge[] : edges){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
           pq.offer(edge);
        }
        int count =1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
            count++;

        }
        if(count>=k)
        return 0;
        int ans=0;
        while(pq.size()>0){
            int rm[] = pq.poll();
            ans =Math.max(ans,rm[2]);
            indegree[rm[0]]--;
            if(indegree[rm[0]]==0)
            count++;
            indegree[rm[1]]--;
            if(indegree[rm[1]]==0)
            count++;
            if(count>=k)
            return ans;
        }
        return -1;
       
        
    }
}