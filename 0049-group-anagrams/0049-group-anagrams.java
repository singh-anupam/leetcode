class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            String s = getSort(str);
            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key :  map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
        
    }

    private String getSort(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        String ans ="";
        for(char ch :  arr)
        {
            ans+=ch;
        }
        return ans;
    }
}