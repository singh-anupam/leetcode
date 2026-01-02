class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);

        return find(arr,0,k,dp);
        
    }

    private int find(int arr[], int idx, int k, int dp[]){
        if(idx>=arr.length)
        return 0;

        if(dp[idx]!=-1)
        return dp[idx];

        int sum =0;
        int ans =0;
        int max =0;

        for(int i=1;i<=k;i++){
            if(idx+i-1>=arr.length)
            continue;
            int element =arr[idx+i-1];

            max = Math.max(max, element);
            sum=max*i;
            ans = Math.max(ans,sum+find(arr,idx+i,k,dp));


        }
        return dp[idx] = ans;
    }
}