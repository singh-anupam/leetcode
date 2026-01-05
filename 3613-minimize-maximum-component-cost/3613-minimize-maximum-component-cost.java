class Solution {
    class Dsu{
        int par[];
        int rank[];
        Dsu(int n){
            par = new int[n+1];
            rank = new int[n+1];
            for(int i=0;i<=n;i++){
                par[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if(par[x]==x)
            return x;
            return par[x]=find(par[x]);
        }

        public boolean union(int u,int v){
            int x = find(u);
            int y = find(v);
            if(x==y)
            return true;
            if(rank[x]>rank[y]){
                par[y]=x;
            }else if(rank[y]>rank[x]){
                par[x]=y;
            }else{
                par[y]=x;
                rank[x]++;
            }
            return false;
        }
    
    }

    private boolean isPossible(int arr[][], int target, int threshold, int n){
        Dsu dsu = new Dsu(n);
        int connected = n;
        for(int edge[] : arr){
            if(edge[2]<=threshold)
            {if(!dsu.union(edge[0],edge[1]))
            connected--;}
        }
        return connected<=target;


    }


    public int minCost(int n, int[][] edges, int k) {

        Dsu dsu = new Dsu(n);

        int l =0;
        int r = 0;
        for(int edge[] : edges)
        r = Math.max(r,edge[2]);
        int ans = r;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(edges,k,mid,n)){
                ans=mid;
                r=mid-1;
            }else
            l=mid+1;
        }

        return ans;
        


        
    }
}