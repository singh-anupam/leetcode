class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
//         boolean vis[] = new boolean[graph.length];
         List<Integer> ans=new ArrayList<>();
        
//         for(int i=0;i<graph.length;i++)
//         {
//             if(!vis[i])
//             dfs(graph,i, vis, new boolean[graph.length],ans);
            
//         }
//         Collections.sort(ans);
//         return ans;
        
        
//     }
//     private boolean dfs(int graph[][],int src, boolean vis[], boolean cycle[], List<Integer> ans)
//     {
//         if(cycle[src])
//             return true;
        
//         vis[src]=true;
//         cycle[src]=true;
//         for(int nbr: graph[src])
//         {
//             if( cycle[nbr])
//                 return true;
//             if(dfs(graph,nbr,vis,cycle,ans))
//             {
//                 return true;
//             }
           
//         }
//         cycle[src]=false;
//         if(!ans.contains(src))
//         ans.add(src);
//         return false;
//     }
        
        List<List<Integer>> graph2 = new ArrayList<>();
    for(int i=0;i<graph.length;i++)
    {
        graph2.add(new ArrayList<>());
       
    }
    Queue<Integer> q = new LinkedList<>();
       int arr[] = new int[graph.length];
    for(int i=0;i<graph.length;i++)
    {
        for(int j : graph[i])
        {
            graph2.get(j).add(i);
            arr[i]++;
        }
    }
 
    for(int i =0;i<arr.length;i++)
    {
        if(arr[i]==0)
        {
            q.offer(i);
              //  System.out.println(i);


        }
    }
    while(q.size()>0)
    {
        int rm = q.poll();
    
        ans.add(0,rm);
        for(int nbr: graph2.get(rm))
        {
            arr[nbr]--;
            if(arr[nbr]==0)
            q.offer(nbr);
        }
    }
     Collections.sort(ans);//Arrays.sort(ans);
     return ans;
        
    }
}