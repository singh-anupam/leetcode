class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // int dp[][] = new int[nums.length+1][target+1];
    
        // Arrays.fill(dp[0],999999);
        // dp[0][0]=0;
        // for(int i=1;i<dp.length;i++)
        // {
        //     for(int j=0;j<dp[0].length;j++)
        //     {
        //         if(nums[i-1]>j)
        //         dp[i][j]=dp[i-1][j];
        //         else
        //         dp[i][j]=Math.min(dp[i-1][j-nums[i-1]]+1,dp[i-1][j]);
        //     }
        // }
        // if(dp[nums.length][target]==999999)
        // return 0;
        // return dp[nums.length][target];
    
        int sum =0;
        int left =0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(sum>=target)
            {
                ans = Math.min(ans,i-left+1);
                sum-=nums[left++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
        
        

        
    }
}