class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int evenSum = 0;
        int oddSum = 0;
        for(int i=0;i<nums.length;i++){
            if((i&1)==0){
                evenSum+=nums[i];
            }else
            oddSum+=nums[i];
        }

        int currEven = 0;
        int currOdd = 0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if((i&1)==0){
                evenSum-=nums[i];
            }else
            oddSum-=nums[i];
            if(evenSum+currOdd==oddSum+currEven)
            ans++;

            if((i&1)==0)
            currEven+=nums[i];
            else
            currOdd+=nums[i];
        }

        return ans;
        
    }
}