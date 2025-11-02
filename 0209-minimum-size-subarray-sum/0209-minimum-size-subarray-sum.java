class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l=0;
        int r = nums.length;
        int ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(nums,target,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
      return ans;
    }

    private boolean isPossible(int arr[], int target, int size){
        int i=0;
        int j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<arr.length){
            sum+=arr[j];
           if(j-i+1==size){
            max=Math.max(max,sum);
            sum-=arr[i++];
           }
            j++;
        }
        return max>=target;
    }
}