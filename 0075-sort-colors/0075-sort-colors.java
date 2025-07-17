class Solution {
    public void sortColors(int[] nums) {
        int cz =0;
        int co = 0;
        int ct = nums.length;

        while(co<ct){
            if(nums[co]==1)
            co++;
            else if(nums[co]==0)
            {
                int temp =nums[co];
               nums[co]=nums[cz];
               nums[cz]=temp;
               cz++;
               co++;

            }
            else{
                ct--;
                nums[co]=nums[ct];
                nums[ct]=2;
            }
        }
        
    }
}