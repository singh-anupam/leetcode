class Solution {
    int par[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            if(find(u,v))
                return edges[i];
        }
        return edges[n-1];
    }
    public boolean find(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        if(lx!=ly)
        {
            if(rank[lx]>rank[ly])
            {
                par[ly]=lx;
            }
            else if(rank[ly]>rank[lx])
            {
                par[lx]=ly;
            }
            else
            {
                par[ly]=lx;
                rank[lx]++;
            }
            return false;
        }
        return true;
    }
    
    public int find(int x)
    {
        if(par[x]==x)
            return x;
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
}