class Solution {
    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int connection[] : connections){
            int u = connection[0];
            int v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(-u);
        }

        boolean vis[] = new boolean[n];

        return dfs(graph, vis,0);
        
    }

    private int dfs(List<List<Integer>> graph , boolean vis[], int src){
        int connections=0;
        vis[src]=true;
        for(int nbr : graph.get(Math.abs(src))){
            if(!vis[Math.abs(nbr)]){
                connections +=dfs(graph,vis,Math.abs(nbr))+(nbr>0?1:0);
            }
        }
        return connections;
    }
}