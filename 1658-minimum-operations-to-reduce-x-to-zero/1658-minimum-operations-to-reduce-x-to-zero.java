class Solution {
    public int minOperations(int[] nums, int x) {
        int sum =0;
        for(int i : nums)
        sum+=i;

        if(sum<x)
        return -1;
        
        sum-=x;

        int l = 0;
        int r =0;
        int curSum =0;
        int ans = Integer.MIN_VALUE;
        while(r<nums.length){
            curSum+=nums[r];
            while(curSum>sum){
                curSum-=nums[l++];
            }
            if(curSum==sum){
                ans = Math.max(ans,r-l+1);
            }
            r++;

        }
        if(ans==Integer.MIN_VALUE)
        return -1;

        return nums.length-ans;
        
    }
}