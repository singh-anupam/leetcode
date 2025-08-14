class Solution {
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length+2];
        arr[0]=1;
        arr[nums.length+1]=1;
        int dp[][] = new int[arr.length][arr.length];
        for(int i=1;i<=nums.length;i++)
        {
            arr[i]=nums[i-1];
        }
        for(int brr[] :  dp)
            Arrays.fill(brr,-1);
        return find(arr,1,nums.length,dp);
        
    }
    public int find(int arr[], int i, int j, int dp[][])
    {
        if(j<i)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k =i;k<=j;k++)
        {
            max = Math.max(max,arr[i-1]*arr[k]*arr[j+1]+find(arr,i,k-1,dp)+find(arr,k+1,j,dp));
        }
        return dp[i][j]=max;
        
    }
}