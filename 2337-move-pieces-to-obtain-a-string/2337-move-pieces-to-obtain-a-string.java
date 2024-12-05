class Solution {
    public boolean canChange(String start, String target) {
        if(start.length()!=target.length())
        return false;
        int i=0;
        int j=0;

        while(i<start.length()  && j<target.length())
        {
            if(start.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }
            else if(start.charAt(i)=='_')
            {
                i++;
            }
            else if(target.charAt(j)=='_')
            {
                j++;
            }
            else
            return false;
        }

        if(j<target.length())
        return false;

        while(i<start.length())
        {
            if(start.charAt(i++)!='_')
            return false;
        }
        
        // while(j<target.length())
        // {
        //     if(target.charAt(j++)!='_')
        //     return false;
        // }
        return true;
        
    }
}