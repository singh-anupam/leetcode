class Solution {
    List<String> ans = new ArrayList<>();

   class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);  
        }
    }

    private void dfs(Map<String,PriorityQueue<String>> map, String src){
       

        while(map.get(src)!=null && map.get(src).size()>0){
            String nbr = map.get(src).poll();
            dfs(map,nbr);

        }
        ans.add(src);
    }


    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String,PriorityQueue<String>> map = new HashMap<>();
        
        for(List<String> list : tickets){
            String u = list.get(0);
            String v = list.get(1);
            PriorityQueue pq = map.getOrDefault(u,new PriorityQueue<>(new StringComparator()));
            pq.offer(v);
            map.put(u,pq);
        }

        dfs(map,"JFK");

         Collections.reverse(ans);
         return ans;


        
    }
}

   