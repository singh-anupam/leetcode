class Solution {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n+1][n+1];
        for(int arr[]:dp)
        Arrays.fill(arr,-1);
        return find(1,n,dp);
        
    }
    public int find(int start, int end, int dp[][])
    {
        if(start>=end)
        return 0;
        if(dp[start][end]!=-1)
        return dp[start][end];
        int min = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++)
        {
            min= Math.min(min,i+Math.max(find(start,i-1,dp),find(i+1,end,dp)));

        }
        return dp[start][end] = min;
    }
}