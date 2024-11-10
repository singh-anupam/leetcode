class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
           
            int l=i+1;
            int r = nums.length-1;
            while(l<r)
            {
                if(Math.abs(nums[l]+nums[r]+nums[i]-target)<min)
                {
                  //  System.out.println(nums[i]+" "+nums[l]+" "+nums[r]);
                    min=Math.abs(nums[l]+nums[r]+nums[i]-target);
                    ans=nums[l]+nums[r]+nums[i];
                }
                if(target-nums[i]-nums[l]-nums[r]>0)
                l++;
                else
                r--;
            }
            
        }
        return ans;
    }
}