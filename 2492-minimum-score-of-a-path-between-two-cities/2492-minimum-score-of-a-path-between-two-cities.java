class Solution {
    class Pair{
        int nbr;
        int wt;
        public Pair(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
        graph.add(new ArrayList<>());

        for(int road[] : roads){
            graph.get(road[0]).add(new Pair(road[1],road[2]));
            graph.get(road[1]).add(new Pair(road[0],road[2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1,Integer.MAX_VALUE));
        int ans = Integer.MAX_VALUE;

        int vis[] = new int[n+1];
        Arrays.fill(vis,Integer.MAX_VALUE);

        while(q.size()>0){
            Pair rm = q.poll();
            ans = Math.min(rm.wt,ans);
            for(Pair p : graph.get(rm.nbr)){
                if(vis[p.nbr]>p.wt){
                    vis[p.nbr]=p.wt;
                    q.offer(p);
                }

            }
        }
        return ans;
    }
}