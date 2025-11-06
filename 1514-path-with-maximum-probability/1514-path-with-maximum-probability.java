class Solution {
    class Pair{
        int x;
        double cost;
        Pair(int x, double cost){
            this.x =x;
            this.cost = cost;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int x=0;
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(new Pair(v,succProb[x]));
            graph.get(v).add(new Pair(u,succProb[x++]));

        }
        double arr[] = new double[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.cost,a.cost));
        pq.offer(new Pair(start,1.0));

        arr[start]=1.0;
        while(pq.size()>0){
            Pair rm = pq.poll();
            System.out.println(rm.x+" "+rm.cost+" "+arr[rm.x]);
            if(rm.x==end)
            return rm.cost;
            for(Pair nbr :  graph.get(rm.x)){
                
                if(arr[nbr.x]<rm.cost*nbr.cost){
                    arr[nbr.x]=rm.cost*nbr.cost;
                     pq.offer(new Pair(nbr.x,nbr.cost*rm.cost));
                   
                }
            }
        }

        return 0.00;




        
    }
}