class Solution {
    public int maxCoins(int[] nums) {

        int arr[] = new int[nums.length+2];
        arr[0]=1;
        arr[nums.length+1]=1;
        for(int i=1;i<=nums.length;i++){
            arr[i]=nums[i-1];
        }
        int dp[][] = new int[arr.length][arr.length];
        for(int d[] : dp)
        Arrays.fill(d,-1);
        return find(arr,0,nums.length+1,dp);
    }

    private int find(int arr[], int start, int end,int dp[][]){
        if(start>end)
        return 0;

        if(dp[start][end]!=-1)
        return dp[start][end];

        int max=0;
        for(int k=start+1;k<end;k++){
            max = Math.max(max,arr[start]*arr[k]*arr[end]+find(arr,start,k,dp)+find(arr,k,end,dp));

        }
        return dp[start][end] = max;
    }
}