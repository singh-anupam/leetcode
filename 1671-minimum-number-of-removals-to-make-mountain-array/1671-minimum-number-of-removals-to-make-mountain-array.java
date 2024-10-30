class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int max=0;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    max= Math.max(max,left[j]);
                }
            }
            left[i]=max+1;
            
        }
        
        
         for(int i=nums.length-1;i>=0;i--)
        {
            int max=0;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    max= Math.max(max,right[j]);
                }
            }
         right[i]=max+1;
            
        }
        
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
           // System.out.println(left[i]+" "+right[i]);
            if(left[i]>1 && right[i]>1)
            count = Math.max(left[i]+right[i]-1,count);
        }
        
        
        return nums.length-count;
        
    }
}