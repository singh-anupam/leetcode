class Solution {
    public boolean canSortArray(int[] nums) {
        int prev_seg_max=-1;
        int curr_seg_max=nums[0];
        int curr_seg_min=nums[0];
        int curr_set_bit=getSetBit(nums[0]);
        int i=1;
        while(i<nums.length){
            int bits= getSetBit(nums[i]);
            while(i<nums.length && bits==curr_set_bit){
                curr_seg_max = Math.max(nums[i],curr_seg_max);
                curr_seg_min = Math.min(nums[i],curr_seg_min);
                i++;
            }
            if(prev_seg_max>curr_seg_min)
            return false;
            else if(i<nums.length)
            {
                prev_seg_max=curr_seg_max;
                curr_seg_max =nums[i];
                curr_seg_min = nums[i];
                curr_set_bit=getSetBit(nums[i]);

            }

        }

        return true;
        
    }

    private int getSetBit(int n)
    {
        int count=0;
        while(n>0)
        {
            n=n&(n-1);
            count++;
        }
        return count;
    }
}