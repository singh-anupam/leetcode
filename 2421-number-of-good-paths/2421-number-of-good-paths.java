class Solution {
    int res =0;
    class Dsu{
        int par[];
        int rank[];
        Dsu(int n){
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
                rank[i]=1;
            }
        }

        public void union(int u, int v, int val[]){
            int x = find(u);
            int y = find(v);
            if(x==y)
            return ;
            if(val[x]==val[y]){
                res+=rank[x]*rank[y];
                rank[x]+=rank[y];
                par[y]=x;
            }
       
            else if(val[x]>val[y]){
                par[y]=x;
            }else{
                par[x]=y;

            }
        }

        public int find(int x){
            if(par[x]==x)
            return x;
            return par[x]=find(par[x]);
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        Arrays.sort(edges,(a,b)->Integer.compare(Math.max(vals[a[0]],vals[a[1]]),Math.max(vals[b[0]],vals[b[1]])));
        Dsu dsu = new Dsu(vals.length);
        res =vals.length;
        for(int i=0;i<edges.length;i++){
            dsu.union(edges[i][0],edges[i][1],vals);
        }
        return res;
        
    }
}