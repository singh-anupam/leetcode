class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        for(int i : nums){
            sum+=i;
        }

        int l =0;
        int r= 0;
        int currSum =0;
        int ans =Integer.MAX_VALUE;
        while(r<nums.length){
            currSum+=nums[r];
            while(l<=r && sum-currSum<x){
                currSum-=nums[l++];
            }
            if(sum-currSum==x){
                ans = Math.min(nums.length-(r-l+1),ans);
            }
            r++;
        }

        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}