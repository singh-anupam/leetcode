class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return find(nums,goal)-find(nums,goal-1);
    }

    private int find(int arr[], int goal){
        int l =0;
        int r = 0;
        int ans =0;
        int sum =0;
        while(r<arr.length){
            sum+=arr[r];
            while(l<=r && sum>goal){
                sum-=arr[l++];
            }
            ans+=(r-l)+1;
            r++;

        }
        return ans;
    }
}