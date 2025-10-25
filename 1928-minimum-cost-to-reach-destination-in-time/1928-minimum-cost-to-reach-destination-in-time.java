class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        List<List<int[]>> graph =new ArrayList<>();
        for(int i=0;i<passingFees.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});

        }

        int minTime[] = new int[passingFees.length];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        minTime[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,passingFees[0]});

        while(pq.size()>0){
            int rm[] = pq.poll();
            int city = rm[0];
            int time = rm[1];
            int cost = rm[2];
            if(city==passingFees.length-1)
            return cost;
            for(int nbr[] : graph.get(city)){

                int nxtCity = nbr[0];
                int nxtTime = nbr[1];
                int newTime = time+nxtTime;
                int newCost = cost+passingFees[nxtCity];
                if(newTime<=maxTime && newTime<minTime[nxtCity]){
                    minTime[nxtCity]=newTime;
                    pq.offer(new int[]{nxtCity,newTime,newCost});
                } 
            }
        }
        return -1;
    }
}