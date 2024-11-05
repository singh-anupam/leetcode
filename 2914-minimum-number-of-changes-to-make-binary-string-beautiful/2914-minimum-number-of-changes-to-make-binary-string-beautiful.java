class Solution {
    public int minChanges(String s) {
        int i=1;
        int count=0;
        while(i<s.length())
        {
            if(s.charAt(i)!=s.charAt(i-1))
            count++;
            i++;
        }
        return count;
    }
}