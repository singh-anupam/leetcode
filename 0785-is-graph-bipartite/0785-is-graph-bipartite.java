class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        
        Arrays.fill(color,-1);
        
        
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(!check(graph,i,color,0))
                    return false;
            }
        }
        return true;
        
    }
    
    private boolean check(int graph[][], int src, int color[], int currColor)
    {
//         color[src] = currColor;
        
//         for(int nbr :  graph[src])
//         {
//             if(color[nbr]==currColor)
//                 return false;
//             if(color[nbr]==-1)
//                 if(!check(graph,nbr,color,1-currColor))
//                     return false;
//         }
//         return true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        color[src] = 0;
        while(!q.isEmpty())
        {
            int rm = q.poll();
            for(int nbr :  graph[rm])
            {
                if(color[nbr]==color[rm])
                    return false;
                else if(color[nbr]==-1)
                {
                    color[nbr] = 1-color[rm];
                    q.offer(nbr);
                    
                }
            }
        }
        return true;
    }
}