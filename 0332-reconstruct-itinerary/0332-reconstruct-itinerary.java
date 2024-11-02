class Solution {
    List<String> result= new ArrayList<>();

    private class ListComparator implements Comparator<String>
    {
        // public int compareTo(String str1,String str2){
        //     int i=0;
        //     int j =0;
        //     while(i<str1.length() && j<str2.length())
        //     {
        //         if(str1.charAt(i)<str2.charAt(j))
        //         return -1;
        //         else if(str1.charAt(i)>str2.charAt(j))
        //         return 1;
        //         i++;
        //         j++;
        //     }
        //     if(i==str1.length())
        //     return -1;
        //     return 1;
        // }

        public int compare(String str1,String str2)
        {
                int i=0;
            int j =0;
            while(i<str1.length() && j<str2.length())
            {
                if(str1.charAt(i)<str2.charAt(j))
                return -1;
                else if(str1.charAt(i)>str2.charAt(j))
                return 1;
                i++;
                j++;
            }
            if(i==str1.length() && j==str2.length())
            return 0;
            if(i==str1.length())
            return -1;
            return 1;
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph  = new HashMap<>();
        int count=0;
        for(List<String> ticket : tickets){
            List<String>list = graph.getOrDefault(ticket.get(0),new ArrayList<>());
            list.add(ticket.get(1));
            graph.put(ticket.get(0),list);
            count++;
        }

        for(String key :  graph.keySet()){
            List<String> list = graph.get(key);
            Collections.sort(list,new ListComparator());
        }
        List<String> ans = new ArrayList<>();
      //  printGraph(graph);

        dfs(graph,"JFK",0,count,ans);
        return result;




        
    }

    private boolean dfs(Map<String,List<String>> graph, String src,int n,int count,List<String> ans){
        ans.add(src);
     //   System.out.println(src);
        if(n==count)
        {
            result =ans;
            return true;
        }
        List<String> nbrs = graph.get(src);
        if(nbrs!=null){
        for(int i=0;i<nbrs.size();i++){
            String nbr = nbrs.get(i);
            nbrs.remove(nbr);
            if(dfs(graph,nbr,n+1,count,ans))
            return true;
            nbrs.add(i,nbr);

        } 
        }
        ans.remove(ans.size()-1);
        return false;
    }

    private void printGraph(Map<String,List<String>> map)
    {
        for(String key : map.keySet())
        {
            System.out.println(key+" "+map.get(key));
        }
    }
}