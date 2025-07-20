class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--)
        {
            boolean flag = false;
            for(int j=i;j<=Math.min(i+nums[i],nums.length-1);j++){
                if(dp[j])
                {
                    flag = true;
                    break;
                }
            }

            dp[i]=flag;
            System.out.println(dp[i]);
        }
        
        return dp[0];
    }
}