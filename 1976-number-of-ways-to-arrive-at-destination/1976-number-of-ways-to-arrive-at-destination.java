class Solution {
    class Pair{
        int x;
        long cost;
        Pair(int x, long cost){
            this.x =x;
            this.cost = cost;
        }
    }
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int road[] : roads){
            graph.get(road[0]).add(new Pair(road[1],road[2]));
            graph.get(road[1]).add(new Pair(road[0],road[2]));
        }
        int ways[] = new int[n];
        long cost[] = new long[n];
        Arrays.fill(cost,Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));

        pq.offer(new Pair(0,1));
        ways[0]=1;
        while(pq.size()>0){
            Pair rm = pq.poll();
            for(Pair p : graph.get(rm.x)){
                int nbr = p.x;
                long nbrCost = p.cost+rm.cost;
                if(cost[nbr]>nbrCost){
                    pq.offer(new Pair(nbr,nbrCost));
                    cost[nbr]=nbrCost;
                    ways[nbr]=ways[rm.x];
                }else if(cost[nbr]==nbrCost){
                    ways[nbr]=(ways[nbr]+ways[rm.x])%mod;
                }
            }

        }
        return ways[n-1];
        
    }
}