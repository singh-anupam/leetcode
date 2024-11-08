class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int mask = (1<<maximumBit)-1;
        int xor = 0;
        for(int num : nums){
            xor^=num;
        }
        xor=xor^mask;

        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=xor;
            xor^=nums[nums.length-i-1];
        }
        return ans;
        
    }
}