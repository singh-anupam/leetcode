class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=start){
                start = nums[i];
            }else {
                r=i;
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<=end){
                end = nums[i];
            }else{
                l=i;
            }
        }

        if(r==0 && l==0)
        return 0;

        return r-l+1;

        
    }
}