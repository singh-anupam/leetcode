class Solution {

class UnionFind{
    private int par[];
    private int size[];

public UnionFind(int n){
    par = new int[n];
    size = new int[n];
    for(int i=0;i<n;i++){
        par[i]=i;
        size[i]=1;
    }
}

    public int find(int x)
    {
        if(par[x]==x) return x;

        return par[x]=find(par[x]);
    }

    public boolean union(int a, int b){
        int par_a = find(a);
        int par_b = find(b);
        if(par_a==par_b)
        return false;

        if(size[par_a]>size[par_b]){
            par[par_b]=par_a;
            size[par_a]+=size[par_b];
        }
        else{
            par[par_a]=par_b;
            size[par_b]+=size[par_a];
        }
        return true;
    }
}

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n+1);

        for(int i=threshold+1;i<=n;i++)
        {
            for(int j=2*i;j<=n;j+=i)
            {
               
                    uf.union(i,j);
                
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(uf.find(u)==uf.find(v))
            ans.add(true);
            else
            ans.add(false);
            
            
        }
        return ans;
        
    }
}