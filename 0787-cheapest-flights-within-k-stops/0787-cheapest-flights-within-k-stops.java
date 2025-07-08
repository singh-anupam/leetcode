class Solution {
    
    class Pair{
        int v;
        int price;
        Pair(int v, int price)
        {
            this.v = v;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int arr[] :  flights)
        {
            graph.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src,0));
        cost[src]=0;
        while(!queue.isEmpty() && k>=0)
        {
            
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                Pair rm = queue.poll();
            for(Pair nbr :  graph.get(rm.v))
            {
                if(cost[nbr.v]>rm.price+nbr.price)
                {
                    cost[nbr.v]=rm.price+nbr.price;
                    queue.offer(new Pair(nbr.v,rm.price+nbr.price));
                 
                }
                 
            }
            }
            k--;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
        
    }
}