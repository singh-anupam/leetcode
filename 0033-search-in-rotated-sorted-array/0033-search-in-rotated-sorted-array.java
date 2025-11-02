class Solution {
    public int search(int[] nums, int target) {
        int lo =0;
        int hi = nums.length-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]>=nums[lo])
            {
                if(nums[lo]<=target && target<=nums[mid])
                    hi=mid-1;
                else
                    lo=mid+1;
            }
            else
            {
                if(nums[hi]>=target && target>=nums[mid])
                    lo =mid+1;
                else
                    hi =mid-1;
            }
            
        }
       // return -1;
        
        
        return -1;
        
    }
//     public int find(int lo, int hi)
//     {
//         while(lo<=hi)
//         {
//             int mid = lo + (hi-lo)/2;
            
//             if(nums[mid]==target)
//                 return mid;
            
//         }
    //}
}