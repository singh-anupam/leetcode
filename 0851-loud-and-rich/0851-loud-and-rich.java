class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<quiet.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<richer.length;i++){
            graph.get(richer[i][1]).add(richer[i][0]);
        }
        
        int ans[] = new int[quiet.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=i;
        }
        dfs(graph,ans,quiet,0);

        return ans;
    }

    private int dfs(List<List<Integer>> graph, int ans[], int quiet[], int src){
                
        for(int nbr: graph.get(src)){
           
           int val =  dfs(graph,ans,quiet,nbr);

        
            if(quiet[ans[src]]>quiet[val]){
                //  System.out.println(src+" "+nbr+" "+ans[src]+" "+ans[nbr]);
                ans[src]=val;
            }
             
        }
        return ans[src];
    }
}