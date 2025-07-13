class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int r =0,l=0,maxLen=0,maxFreq=0;
        while(r<s.length()){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
            while(r-l+1-maxFreq>k){
                char lchar = s.charAt(l);
                map.put(lchar,map.get(lchar)-1);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
        
    }
}