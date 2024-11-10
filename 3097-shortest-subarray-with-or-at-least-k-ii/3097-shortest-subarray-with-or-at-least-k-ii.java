class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int l=0;
        int r=0;
        int ans=Integer.MAX_VALUE;
        int arr[] = new int[32];
        while(r<nums.length)
        {
            update(arr,nums[r],1);
            while(l<=r && getDecimalRepresentation(arr)>=k)
            {
                ans=Math.min(r-l+1,ans);
                update(arr,nums[l],-1);
                l++;
            }
            r++;
        }

        return ans;

        
    }

    private void update(int binarr[], int num, int val){
        for(int i=0;i<32;i++)
        {
            if(((num>>i)&1)==1){
                binarr[i]+=val;
            }
        }
    }

    private int getDecimalRepresentation(int arr[])
    {
        int num=0;
        for(int i=0;i<32;i++)
        {
            if(arr[i]>0)
            num|=(1<<i);
        }

        return num;
    }
}