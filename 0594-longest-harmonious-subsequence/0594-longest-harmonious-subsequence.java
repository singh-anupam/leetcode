class Solution {
    public int findLHS(int[] nums) {
        // int max= 0;
       Arrays.sort(nums);
       int l=0,r=0;
       int ans=0;
       while(r<nums.length){
        while(l<r && nums[r]-nums[l]>1)
        l++;
        if(nums[l]!=nums[r])
        ans=Math.max(ans,r-l+1);
        r++;
       }
       return ans;
        
    }
}