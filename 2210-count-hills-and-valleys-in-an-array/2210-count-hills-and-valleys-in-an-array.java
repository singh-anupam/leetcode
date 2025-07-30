class Solution {
    public int countHillValley(int[] nums) {
        int left = 0;
        int count = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                if((nums[i]>nums[left] && nums[i]>nums[i+1]) || (nums[i]<nums[i+1] && nums[i]<nums[left]) )
                {
                    count++;
                }
                left =i;
            }
        }
        return count;
    }
}