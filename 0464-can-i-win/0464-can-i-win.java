class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        Boolean dp[] = new Boolean[(1<<maxChoosableInteger)];
        return solve(desiredTotal, maxChoosableInteger, dp, 0);
    }
    
    private boolean solve(int desiredTotal, int maxChoosableInteger, Boolean[] dp, int state){
        if(desiredTotal <= 0){
            return false;
        }
        if(dp[state] != null){
            return dp[state];
        }
        for(int i=0; i < maxChoosableInteger; i++){
            if(((state >> i) & 1) == 0){
                if(!solve(desiredTotal - (i+1), maxChoosableInteger, dp, (state | (1 << i)))){
                    return dp[state] = true;
                }
            }
        }
        return dp[state] = false;
    }
}