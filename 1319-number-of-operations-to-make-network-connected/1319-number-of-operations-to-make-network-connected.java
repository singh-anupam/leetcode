class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        DSU dsu = new DSU(n);
        int component= n;
        for(int i=0;i<connections.length;i++)
        {
            int x = connections[i][0];
            int y = connections[i][1];
            int parx = dsu.find(x);
            int pary = dsu.find(y);
            if(parx==pary)
                continue;
            dsu.union(x,y);
            component--;
            
            
        }
        return component-1;
        
    }
}

class DSU
{
    int par[];
    int rank[];
    DSU(int size)
    {
        par = new int[size];
        rank = new int[size];
        
        for(int i=0;i<size;i++)
            par[i]=i;
    }
    
    public int find(int x)
    {
        if(par[x]==x)
            return x;
        return par[x] = find(par[x]);
    }
    
    public void union(int x, int y)
    {
        int parx = find(x);
        int pary =  find(y);
        
        if(rank[parx]>rank[pary])
            par[pary] = parx;
        else if(rank[pary]>rank[parx])
            par[parx]=pary;
        else
        {
            par[pary]=parx;
            rank[parx]++;
        }
    }
}