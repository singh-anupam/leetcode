class Solution {
    public String compressedString(String word) {
        int left =0;
        int right =0;
        String ans ="";
        int count=0;
        while(right<word.length())
        {
            while(right<word.length() && word.charAt(right)==word.charAt(left)){
                right++;
                count++;
                if(count==9)
                break;
                
            }
             ans+=count;
            ans+=word.charAt(left);
           
            count=0;
            left=right;

        }
       // ans+=word.charAt(left)+count;
        return ans;
        
    }
}