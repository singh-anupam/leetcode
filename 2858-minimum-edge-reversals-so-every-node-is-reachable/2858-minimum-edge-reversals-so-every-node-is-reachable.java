class Solution {
    class Pair{
        int nbr;
        int cost;
        Pair(int nbr, int cost) {
            this.nbr=nbr;
            this.cost = cost;
        }
    }
    public int[] minEdgeReversals(int n, int[][] edges) {

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(new Pair(v,0));
            graph.get(v).add(new Pair(u,1));
        }
        
        int ans[] = new int[n];
        boolean vis[] = new boolean[n];
      ans[0]=  dfs(graph,0,vis);
      System.out.println(ans[0]);
      vis = new boolean[n];
      reset(graph,0,vis,ans);
        return ans;
    }

    private void reset(List<List<Pair>> graph, int src, boolean vis[],int ans[]){
        for(Pair p : graph.get(src)){
            if(!vis[p.nbr]){
                vis[p.nbr]=true;
                if(p.cost==0)
                ans[p.nbr]=(ans[src]+1);
                else
                ans[p.nbr]=ans[src]-1;
                reset(graph,p.nbr,vis,ans);

            }
        }
        

    }

    private int dfs(List<List<Pair>> graph, int src, boolean vis[]){
  
       int x =0;
        vis[src]=true;
       
        for(Pair p : graph.get(src)){
            if(!vis[p.nbr]){
               
               x+=dfs(graph,p.nbr,vis)+p.cost;
            }
        }
        return x;
    }
}