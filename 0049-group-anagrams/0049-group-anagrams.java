class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String s :  map.keySet())
        {
            ans.add(map.get(s));
        }
        return ans;
        
    }
}