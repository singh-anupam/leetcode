class Solution {

    class Pair{
        int x;
        int color;
        Pair(int x, int c){
            this.x =x;
            this.color = c;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int edge[] : redEdges){
            graph.get(edge[0]).add(new Pair(edge[1],1));
        }

         for(int edge[] : blueEdges){
             graph.get(edge[0]).add(new Pair(edge[1],-1));
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,1));
        q.offer(new Pair(0,-1));
        int path =0;
        int count =0;
        ans[0]=0;
        while(q.size()>0){
            int size = q.size();
            path++;
            for(int i=0;i<size;i++){
                Pair rm = q.poll();
                for(Pair nbr : graph.get(rm.x)){
                    if(nbr.color!=rm.color && ans[nbr.x]>path){
                        q.offer(nbr);
                         ans[nbr.x]=path;
                    }
                }
               
            }
            
        }

        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE)
            ans[i]=-1;
        }
        return ans;
    }
}