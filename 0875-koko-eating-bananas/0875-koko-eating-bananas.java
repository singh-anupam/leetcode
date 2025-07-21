class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int r =0;
        for(int i :  piles)
        {
            r = Math.max(i,r);
        }
        int l =1;
        int ans=r;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isAble(piles,mid,h))
            {
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
    private boolean isAble(int arr[], int t, int target)
    {
        long count=0;
        for(int i : arr)
        {
            count+=i/t;
            if(i%t!=0)
            count+=1;

        }
        return count<=target;
    }
}