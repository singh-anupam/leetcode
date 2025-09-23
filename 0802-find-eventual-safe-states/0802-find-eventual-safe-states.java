class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int indegree[] = new int[graph.length];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            list.add(new ArrayList<>());
        }
     for(int i=0;i<graph.length;i++)
     {
        // for(int j  =0;j<graph[0].length;j++)
        // {
        //     if(graph[i].length==0)
        //     indegre
        // }
        for(int j : graph[i])
        {
            list.get(j).add(i);
        }
        indegree[i]=graph[i].length;
     }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0)
            {
                q.add(i);
                indegree[i]--;
            }

        }
        List<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            int rm = q.poll();
            ans.add(rm);
            for(int nbr : list.get(rm)){
                indegree[nbr]--;
                if(indegree[nbr]==0)
                q.offer(nbr);
            }
        }
         Collections.sort(ans);
         return ans;
    }
}