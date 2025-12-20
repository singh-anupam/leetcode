class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        List<String> ans = new ArrayList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        for(int i=0;i<recipes.length;i++){
          for(String ingred : ingredients.get(i)){
           List<String> l = graph.getOrDefault(ingred,new ArrayList<>());
            l.add(recipes[i]);
            graph.put(ingred,l);
            indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
          }
        }

        

        Queue<String> q = new LinkedList<>();

        for( String str :  available){
            q.offer(str);
        }

        while(q.size()>0){
            String str =  q.poll();
            if(!graph.containsKey(str))
            continue;
            for( String rec : graph.get(str)){
                int degree = indegree.get(rec);
                degree--;
                indegree.put(rec,degree);
                if(degree==0){
                    indegree.remove(rec);
                    q.offer(rec);
                    ans.add(rec);
                }
            }
        }
        return ans;
        
    }
}