class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
       

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<patience.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
         int dist[] = disjKastras(graph);

         return getMaxTime(dist,patience);
        
    }

    private int getMaxTime(int dist[], int patience[]){
        int ans = 0;
        for(int i=1;i<patience.length;i++){
            int time = dist[i]*2;
            int p = patience[i];
            int numberOfMessage = time/p;
            if(time%p==0)
            numberOfMessage--;

            int lastMessageSentTime = numberOfMessage*p;

            ans = Math.max(ans,lastMessageSentTime+time+1);

        }
        return ans;

    }

    private int[] disjKastras(List<List<Integer>> graph){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
         int arr[] = new int[graph.size()];
        Arrays.fill(arr,Integer.MAX_VALUE);
        boolean vis[] = new boolean[graph.size()];

        arr[0]=0;
        pq.offer(new int[]{0,0});
        while(pq.size()>0){
            int rm[] = pq.poll();
            if(!vis[rm[0]]){
                for(int nbr : graph.get(rm[0])){
                    if(arr[nbr]>arr[rm[0]]+1){
                        arr[nbr]=arr[rm[0]]+1;
                        pq.offer(new int[]{nbr,arr[nbr]});
                    }
                }
            }
        }
        return arr;
    }
}