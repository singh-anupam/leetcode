class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length())
        return false;
        int count=0;
        char ch1 = '0';
        char ch2 ='0';
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(count==2)
                return false;
                if(count==1){
                    if(s1.charAt(i)!=ch2 || s2.charAt(i)!=ch1)
                    return false;
                    count++;

                }
                if(count==0){
                    ch1=s1.charAt(i);
                    ch2=s2.charAt(i);
                    count++;
                }
            }
        }
        if(count==1)
        return false;
        return true;

        
    }
}