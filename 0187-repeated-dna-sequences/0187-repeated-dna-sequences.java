class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<=10)
        return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int i=0;
        String str ="";
        while(i<10){
            str+=s.charAt(i++);
           
        }
         set.add(str);

        while(i<s.length()){
            String sub =s.substring(i-10,i);
            if(set.contains(sub) && !ans.contains(sub))
            ans.add(sub);
            else
            set.add(sub);
            i++;
        }

        // for(String st :  set){
        //     System.out.println(st);
        // }
        return ans;
        
    }
}