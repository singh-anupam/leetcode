class Solution {
    class UnionFind{
        int par[];
        int rank[];
        public UnionFind(int n){
            par = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                par[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if(par[x]==x) return x;
            return par[x] =find(par[x]);
        }

        public boolean union(int a, int b){
            int par_a = find(a);
            int par_b = find(b);
            if(par_a==par_b)
            return true;
            if(rank[par_a]>=rank[par_b]){
                par[par_b]=par_a;
                rank[par_a]+=rank[par_b];
            }
            else{
                par[par_a]=par_b;
                rank[par_b]+=rank[par_a];
            }
            return false;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int indegree[] = new int[edges.length+1];
        Arrays.fill(indegree,-1);
        int bl1=-1;
        int bl2=-1;
        int n = edges.length+1;
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(indegree[v]!=-1)
            {
                bl1=i;
                bl2 =indegree[v];
            }else
            indegree[v]=i;
        }
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(bl1==i)
                continue;
            if(uf.union(u,v)){
                if(bl1==-1)
                return edges[i];
                return edges[bl2];
                

            }
        }
        return edges[bl1];

        
    }
}