class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            int cnt = map.getOrDefault(ch,0)+1;
            map.put(ch,cnt);
        }

        Map<Character,Integer> runningMap = new HashMap<>();
        int l =0;
        int r =0;
        int count =0;
        int len = s.length()+1;
        String ans ="";
        while(r<s.length()){
            char ch = s.charAt(r);
            int cnt = runningMap.getOrDefault(ch,0)+1;
            runningMap.put(ch,cnt);
            if(map.containsKey(ch) && map.get(ch)>=runningMap.get(ch)){
                count++;
            }
            System.out.println("count "+count);
            while(count==t.length()){
                // System.out.println(s.substring(l,r+1));
                if(r-l+1<len){
                    ans = s.substring(l,r+1);
                    len = r-l+1;
                }
                // printMap(map);
                // printMap(runningMap);
                
                 char ch2 = s.charAt(l++);
                 int cnt2 = runningMap.get(ch2)-1;
            runningMap.put(ch2,cnt2);
            int ct = map.getOrDefault(ch2,0);
            if(cnt2<ct)
            count--;

            } 
            r++;
        }
        return ans;
        
    }

    private void printMap(Map<Character,Integer> map){
        for(Character ch : map.keySet()){
            System.out.print(ch+"->"+map.get(ch)+" ");
        }
        System.out.println();
    }
}