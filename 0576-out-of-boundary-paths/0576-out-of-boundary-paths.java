class Solution {
    int mod =1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][]=new long[m][n][maxMove+1];
        for(int i=0;i<m;i++)
        {
            for(long arr[] : dp[i])
            Arrays.fill(arr,-1);
        }

        return (int)find(m,n,startRow,startColumn, maxMove, dp);
    }

    private long find(int m,int n, int i, int j, int count,long dp[][][])
    {
        if(count<0)
        return 0;
        if(i>=m || j>=n || i<0 || j<0 )
        return 1;
        if(dp[i][j][count]!=-1)
        return dp[i][j][count];

        long left = find(m,n,i,j-1,count-1,dp);
        long right = find(m,n,i,j+1,count-1,dp);
        long up = find(m,n,i-1,j,count-1,dp);
        long down = find(m,n,i+1,j,count-1,dp);
        long sum = left+right+up+down;
        return dp[i][j][count]=(left+right+up+down)%mod;

    }
}