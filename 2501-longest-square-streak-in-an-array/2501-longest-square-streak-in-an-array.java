class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
  
     int dp[][] = new int[nums.length][nums.length];
     for(int arr[]:dp)
     Arrays.fill(arr,-1);
        int x =find(nums,0,-1,dp);

     return x==1?-1:x;
        
    }

    private int find(int arr[], int idx, int prev, int dp[][])
    {
        if(idx==arr.length)
        return 0;
        if(prev==-1)
        {
            int take = find(arr,idx+1,idx,dp)+1;
            int notTake = find(arr,idx+1,prev,dp);
            return Math.max(take,notTake);
        }
        if(dp[idx][prev]!=-1)
        return dp[idx][prev];
        if(arr[idx]==arr[prev]*arr[prev])
        return dp[idx][prev]=find(arr,idx+1,idx,dp)+1;

        return dp[idx][prev]=find(arr,idx+1,prev,dp);
    }
}