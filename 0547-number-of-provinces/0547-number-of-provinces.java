class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int count =0;
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(!vis[i] && isConnected[i][j]==1)
                {
                    count++;
                    dfs(isConnected,i,vis,n);
                }
            }
        }
        return count;
        
    }
    
    private void dfs(int graph[][], int i , boolean vis[], int n)
    {
        if(vis[i])
            return;
        vis[i]=true;
        for(int col = 0;col<n;col++)
        {
            if(graph[i][col]==1)
                dfs(graph,col,vis,n);
        }
       
        
    }
}