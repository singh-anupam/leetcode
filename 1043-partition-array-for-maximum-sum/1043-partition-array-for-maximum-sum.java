class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);

        return find(arr,k,0,dp);
        
    }

    private int find(int arr[], int k, int pos, int dp[])
    {
        if(pos==arr.length)
        return 0;
        if(dp[pos]!=-1)
        return dp[pos];
        int l= pos;
        int ans =Integer.MIN_VALUE;
        int r = Math.min(pos+k,arr.length);
        int max =arr[pos];
        int count=1,sum=0;
        for(int i =l;i<r;i++){
            max = Math.max(arr[i],max);
            sum=(count*max)+find(arr,k,i+1,dp);
            count++;
            ans =Math.max(sum,ans);

        }
        return dp[pos]= ans;
    }
}