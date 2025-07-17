class Solution {
     List<Integer> ans;
    public int[][] validArrangement(int[][] pairs) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        for(int arr[] : pairs){
            List<Integer> list = graph.getOrDefault(arr[0],new ArrayList<>());
            list.add(arr[1]);
            graph.put(arr[0],list);
            indegree.put(arr[0],indegree.getOrDefault(arr[0],0)+1);
            indegree.put(arr[1],indegree.getOrDefault(arr[1],0)-1);
        }

        int src = pairs[0][0];

        for(int key  : indegree.keySet()){
            if(indegree.get(key)==1){
                src =key;
                break;
            }
        }

         ans = new ArrayList<>();

        dfs(graph,src);
        Collections.reverse(ans);

         int[][] result=new int[pairs.length][2];
        for(int i=1; i<ans.size(); i++){
            result[i-1][0]=ans.get(i-1);
            result[i-1][1]=ans.get(i);
        }

        return result;




        
    }

    private void dfs(Map<Integer,List<Integer>> graph, int src){
         while(graph.containsKey(src) && !graph.get(src).isEmpty()){
            int v=graph.get(src).remove(0);
            dfs(graph, v);
        }
        ans.add(src);
            
    }
    
}