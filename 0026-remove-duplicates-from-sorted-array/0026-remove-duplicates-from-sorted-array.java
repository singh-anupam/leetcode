class Solution {
    public int removeDuplicates(int[] nums) {
        
        int left =0;
        int right =0;
        while(right<nums.length)
        {
            while(right<nums.length && nums[left]==nums[right])
            {
                right++;
            }
            left++;
            if(right==nums.length)
                return left;
            nums[left]=nums[right];
        }
        
        return nums.length;
        
    }
}