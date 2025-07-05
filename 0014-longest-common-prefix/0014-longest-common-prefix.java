class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs,(a,b)->a.length()-b.length());
        String lp = strs[0];
        for(int i=1;i<strs.length;i++){
            String tmp ="";
            String s = strs[i];
            for(int j=0;j<lp.length();j++)
            {
                if(lp.charAt(j)!=s.charAt(j))
                {
                    lp=tmp;
                    break;
                }
                tmp+=s.charAt(j);
            }
            if(lp.length()==0)
            return "";
        }
        return lp;
        
    }
}