class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        // Collections.nCopies(graph,new ArrayList<>());
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int ans[] = new int[queries.length];
        int i=0;

        for(int x=0;x<n-1;x++){
            graph.get(x).add(x+1);
        }
        
        for(int query[] : queries){
            int u = query[0];
            int v = query[1];
            graph.get(u).add(v);
            ans[i++]=bfs(graph,n-1);
        }
        return ans;
    }

    private int bfs(List<List<Integer>> graph, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int level =0;
        while(q.size()>0){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                int rm = q.poll();
                for(int nbr : graph.get(rm)){
                    // System.out.print(rm+" "+nbr+" "+level+" ");
                    if(nbr==n)
                    return level;
                    q.offer(nbr);
                }
              
            }
              System.out.println();
        }
        return level;
    }
}