class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,1);
       // color[0]=0;
        for(int i=0;i<graph.length;i++)
       {
           if(color[i]==1)
           {color[i]=0;
           if(!dfs(graph,i,color))
           return false;
           }
       }
       return true;
        
    }
    public boolean dfs(int [][]graph,int src,int color[])
    {
        for(int nbr : graph[src])
        {
            if(color[nbr]==1)
            {
                color[nbr]=-1-color[src];
                if(!dfs(graph,nbr,color))
                return false;
            }
            if(color[nbr]==color[src])
            return false;
          
        }
        return true;
    }
}