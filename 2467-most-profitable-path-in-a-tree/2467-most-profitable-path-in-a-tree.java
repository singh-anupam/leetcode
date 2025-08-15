class Solution {
 
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> graph = new ArrayList<>();
  
        for(int i=0;i<amount.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int bobPath[] = new int[amount.length];
        Arrays.fill(bobPath,-1);
        List<Integer> path = new ArrayList<>();
        buildBobPath(graph,bob,-1,path);

        for(int i=0;i<path.size();i++){
            bobPath[path.get(i)]=i;
        }

        return find(graph,0,bobPath,-1,amount,0,0);
        
        
        
    }
    private boolean buildBobPath(List<List<Integer>> graph, int src, int parent, List<Integer> path ){
        if(src==0)
        return true;
        for(int nbr : graph.get(src)){
            if(nbr!=src){
                path.add(src);
                if(buildBobPath(graph,nbr,src,path))
                return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private int find(List<List<Integer>> graph , int src, int bobPath[], int parent, int amount[], int time, int curScore ){
        if(bobPath[src]==-1 || bobPath[src]>time)
        curScore+=amount[src];
        else if(bobPath[src]==time)
        curScore+=amount[src]/2;
        // System.out.println(src);
        if(graph.get(src).size()==1 && src!=0)
        return curScore;

        int max = Integer.MIN_VALUE;


        for(int nbr :graph.get(src)){
            if(nbr!=parent){
                max = Math.max(max, find(graph,nbr,bobPath,src,amount,time+1, curScore));
            }
        }
        return max;

    }
}