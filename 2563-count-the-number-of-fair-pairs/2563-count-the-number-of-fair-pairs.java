class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int target = lower-nums[i];
            int lowerBoundIndex = lowerBound(nums,i+1,nums.length-1,target);
            
            int lcnt = lowerBoundIndex-i-1;
             target = upper-nums[i];
            int upperBoundIndex = upperBound(nums,i+1,nums.length-1,target);
            int ucnt = upperBoundIndex-i-1 ;
            System.out.println(lowerBoundIndex+" "+upperBoundIndex);
            ans+=ucnt-lcnt;
        }
        return ans;
        
    }

    private int lowerBound(int arr[], int l, int r, int target){
        int ans=r+1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]>=target){
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }

    private int upperBound(int arr[], int l, int r, int target)
    {
        int ans=r+1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]<=target)
            {
                l=mid+1;
            }
            else
            {
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
}