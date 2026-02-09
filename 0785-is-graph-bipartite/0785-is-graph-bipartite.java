class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        // color[0]=0;
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!dfs(graph,color,i))
                return false;
            }
        }

        return true;
        
    }

    private boolean dfs(int graph[][], int color[], int src){
        
        for(int nbr : graph[src]){
            if(color[nbr]==color[src])
            return false;
            else if(color[nbr]==-1)
            {
                color[nbr]=1-color[src];
                if(!dfs(graph,color,nbr))
                 return false;
            }

        }

        return true;
    }

}