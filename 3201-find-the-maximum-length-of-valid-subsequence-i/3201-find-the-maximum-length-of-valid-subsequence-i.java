class Solution {
    public int maximumLength(int[] nums) {
        int x =0;
        int y =0;
        int cnte=0,cnto=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
            {
                cnte++;
                x=i==0?1:y+1;
            }
            else {
           y=i==0?1:x+1;
            
            cnto++;
            }
            
        }

        int max = Math.max(x,y);
        int max2 = Math.max(cnte,cnto);
        return Math.max(max,max2);


        
    }

   
}