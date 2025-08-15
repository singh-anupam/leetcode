class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x =x;
            this.y = y;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        Queue<Pair> pq = new LinkedList<>();

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0],edge[2]));

        }

        pq.offer(new Pair(0,0));
        int vis[] = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        vis[0]=0;
        while(pq.size()>0){
             Pair pair = pq.poll();
            if(pair.y>vis[pair.x])
            continue;
            for(Pair p : graph.get(pair.x)){
                if(vis[p.x]>p.y+pair.y && p.y+pair.y<disappear[p.x]){
                   
                    vis[p.x]=p.y+vis[pair.x];
                    pq.add(new Pair(p.x,vis[p.x]));
                 
                    
                }

            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==Integer.MAX_VALUE)
            vis[i] =-1;
            
        }
        return vis;
        
    }
}