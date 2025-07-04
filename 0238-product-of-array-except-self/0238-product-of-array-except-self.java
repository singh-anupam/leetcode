class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int prev =1;
        for(int i=0;i<nums.length;i++){
            left[i]=nums[i]*prev;
            prev*=nums[i];
        }
        prev=1;
        int ans[] = new int[nums.length];
        for(int i=nums.length-1;i>0;i--){
            ans[i]=left[i-1]*prev;
            prev*=nums[i];
        }
        ans[0]=prev;
        return ans;
        
    }
}