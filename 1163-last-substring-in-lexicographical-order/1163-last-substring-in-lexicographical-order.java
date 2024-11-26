class Solution {
    public String lastSubstring(String s) {
        int maxCharIndex = s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)>s.charAt(maxCharIndex)){
                maxCharIndex=i;
            }
            else if(s.charAt(i)==s.charAt(maxCharIndex)){
                int x=i+1;
                int y=maxCharIndex+1;
                while(x<maxCharIndex && y <s.length() && s.charAt(x)==s.charAt(y)){
                    x++;
                    y++;
                }
                if(x==maxCharIndex || y ==s.length() || s.charAt(x)>s.charAt(y))
                {
                    maxCharIndex=i;
                }
            }
        }

        return s.substring(maxCharIndex);
        
    }
}