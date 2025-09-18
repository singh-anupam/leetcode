class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int arr[]: dislikes)
        {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        int color[] = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++)
        {
            if(color[i]==-1)
            {
                if(!bfs(graph,i,color))
                return false;
            }
        }
        return true;
        
    }
    public boolean bfs(List<List<Integer>> graph, int src, int color[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty())
        {
            int rm = q.poll();
          for(int nbr : graph.get(rm))
          {
              if(color[nbr]==-1)
              {
                  color[nbr]=1-color[rm];
                  q.offer(nbr);
              }
              else if(color[nbr]==color[rm])
              {
                  return false;
              }
          }
        }
        return true;
    }
}