class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        int ans[] = new int[queries.length];
        Arrays.fill(ans,-1);

        List<int[]>[] list = new ArrayList[heights.length];
        for(int i=0;i<heights.length;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(u<v && heights[u]<heights[v]){
                ans[i]=v;
            }else if(u>v && heights[u]>heights[v]){
                ans[i]=u;
            }else if(u==v){
                ans[i] = u;
            }else{
                list[Math.max(u,v)].add(new int[]{Math.max(heights[u],heights[v]),i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<heights.length;i++){
            while(pq.size()>0 && pq.peek()[0]<heights[i]){
                ans[pq.poll()[1]]=i;
            }
            for(int arr[] :list[i])
            pq.offer(arr);

        }

        return ans;

        
    }
}