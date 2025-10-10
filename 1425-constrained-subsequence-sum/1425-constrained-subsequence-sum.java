class Solution {
   // int ans = Integer.MIN_VALUE;
    int x;
    int max=Integer.MIN_VALUE;
    public int constrainedSubsetSum(int[] nums, int k) {
        x=k;
        if(k==1)
        {
            for(int i : nums)
            max=Math.max(i,max);
        
        return max;
        }
        return find(nums,0,k,0);
        
    }
    public int find(int nums[], int idx, int k,int lidx)
    {
        if(idx==nums.length)
        return 0;
        if(idx-lidx>k)
        return -999999;
        int take = nums[idx]+find(nums,idx+1,k,idx);
        int nTake = find(nums,idx+1,k,lidx);
        return Math.max(take,nTake);
    }
}