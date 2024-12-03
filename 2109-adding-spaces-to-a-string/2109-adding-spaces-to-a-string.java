class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0;
        StringBuilder ans =new StringBuilder();
        int x =0;
        while(i<s.length())
        {
            if(x<spaces.length && spaces[x]==i){
                ans.append(" ");
                x++;
            }
            else{
                ans.append(s.charAt(i++));
            }

        }
        return ans.toString();
        
    }
}