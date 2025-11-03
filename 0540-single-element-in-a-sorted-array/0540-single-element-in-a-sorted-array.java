class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l =0;
        int r =nums.length-1;
        while(l<r)
        {
            int mid = l+(r-l)/2;
            
            boolean isEven = (r-mid)%2==0;
            
            if(nums[mid]==nums[mid+1])
            {
                if(!isEven)
                    r=mid-1;
                else
                    l=mid+2;
                
            }
            else
            {
                if(!isEven)
                    l=mid+1;
                else
                    r=mid;
                    
            }
        }
        return nums[r];
        
    }
}