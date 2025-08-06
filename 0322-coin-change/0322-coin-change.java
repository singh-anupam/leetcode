class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++ )
        {
            int min =Integer.MAX_VALUE;
            for(int j: coins)
            {
                //int val=Integer.MAX_VALUE;
                
               if(j<=i)
                {
                   min=Math.min(dp[i-j],min);
                
                }
                dp[i]=min!=Integer.MAX_VALUE?min+1:Integer.MAX_VALUE;
            }
            
        }
        
          return  dp[amount]==Integer.MAX_VALUE?-1:dp[amount]; 
        
    }
}