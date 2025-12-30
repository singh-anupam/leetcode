class Solution {
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

        public void union(int u, int v){
            int x = find(u);
            int y = find(v);
            if(x==y)
            return ;
            if(rank[x]>rank[y]){
                par[y]=x;
                

            }else if(rank[y]>rank[x]){
            par[x]=y;
            }else{
                rank[x]++;
                par[y]=x;
            }
        }

        public int find(int x){
            if(par[x]==x)
            return x;
            return par[x] = find(par[x]);

        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        
        for(int i=0;i<queries.length;i++){
                queries[i] = new int[]{queries[i][0],queries[i][1],queries[i][2],i};
        }
    
        Dsu dsu = new Dsu(n);
        Arrays.sort(edgeList,(a,b)->Integer.compare(a[2],b[2]));
        Arrays.sort(queries,(a,b)->Integer.compare(a[2],b[2]));
        

        boolean res[] = new boolean[queries.length];
        int i =0;
        for(int q[] : queries){
            while(i<edgeList.length && edgeList[i][2]<q[2]){
                dsu.union(edgeList[i][0],edgeList[i][1]);
                i++;
            }
            if(dsu.find(q[0])==dsu.find(q[1]))
            res[q[3]]=true;
        }

        return res;

        
    }
}