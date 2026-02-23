class Solution {
    int mod = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][] = new int[m][n][maxMove+1];
        for(int d[][] : dp)
        for(int b[] : d)
        Arrays.fill(b,-1);
        return find(m,n,maxMove,startRow,startColumn,dp);
        
    }

    private int find(int m, int n, int move,int i, int j, int dp[][][]){
        if(i<0 || j<0 || i>=m || j>=n)
        return 1;
        if(move<=0)
        return 0;
        if(dp[i][j][move]!=-1)
        return dp[i][j][move];
        int d = find(m,n,move-1,i+1,j,dp);
        int u = find(m,n,move-1,i-1,j,dp);
        int l = find(m,n,move-1,i,j-1,dp);
        int r = find(m,n,move-1,i,j+1,dp);
        return dp[i][j][move] = ((u+d)%mod+(l+r)%mod)%mod;

    }
}