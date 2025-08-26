class Solution {
    class Pair{
        int nbr;
        double x;
        Pair(int nbr, double x){
            this.nbr = nbr;
            this.x = x;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        double vis[] = new double[n];
        int y =0;

        for(int edge[]: edges){
            graph.get(edge[0]).add(new Pair(edge[1],succProb[y]));
            graph.get(edge[1]).add(new Pair(edge[0],succProb[y++]));
        }
        return find(graph,start_node,end_node, vis);
        
    }

    private double find(List<List<Pair>> graph, int src, int dst, double vis[]){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,1));
        while(q.size()>0){
            Pair rm = q.poll();
            for(Pair p : graph.get(rm.nbr)){
                if(vis[p.nbr]<rm.x*p.x){
                    q.offer(new Pair(p.nbr,p.x*rm.x));
                    vis[p.nbr]=rm.x*p.x;

                }
            }
        }
        return vis[dst];
    }
}