class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0,sum=0;
        int right=0;
        int ans = Integer.MIN_VALUE;
        while(right<nums.length)
        {
         sum+=nums[right++];
            ans = Math.max(sum,ans);
            while(sum<0)
                sum-=nums[left++];
            
        
            
        }
        return ans;
        
    }
}