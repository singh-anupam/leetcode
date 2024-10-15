class Solution {
    public long minimumSteps(String s) {
        
        long zero = 0;
        long one = 0;
        long moves = 0;
        for(char ch : s.toCharArray())
        {
            if(ch=='1') one++;
            else
                moves+=one;
            
        }
        return moves;
        
    }
}