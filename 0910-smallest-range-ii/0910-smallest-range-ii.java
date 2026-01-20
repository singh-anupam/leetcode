class Solution {
    public int smallestRangeII(int[] nums, int k) {

        Arrays.sort(nums);
        int ans = nums[nums.length-1]-nums[0];
        int min = nums[0]+k;
        int max = nums[nums.length-1]-k;
        for(int i=1;i<nums.length;i++){
            min = Math.min(nums[0]+k,nums[i]-k);
            max = Math.max(nums[nums.length-1]-k,nums[i-1]+k);
            ans = Math.min(ans,max-min);
        }
        return ans;
        
    }
}