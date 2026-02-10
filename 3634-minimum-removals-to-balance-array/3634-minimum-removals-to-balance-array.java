class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int len = 0;
        while(r<nums.length){
            while((long)(nums[r])>((long)nums[l]*k)){
                l++;
            }
            len = Math.max(len,r-l+1);
            r++;
        }

        return nums.length-len;
        
    }
}