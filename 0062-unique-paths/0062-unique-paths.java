class Solution {
    public int uniquePaths(int m, int n) {
        // int dp[][] = new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 || j==0){
        //             dp[i][j]=1;
        //         }else
        //         dp[i][j]=dp[i-1][j]+dp[i][j-1];

        //     }
        // }

        // return dp[m-1][n-1];
        int dp[][] = new int[m][n];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        return find(m-1,n-1,dp);
        
    }

    private int find(int m, int n, int dp[][]){
        if(m==0 && n==0)
        return 1;
        if(m<0 || n<0)
        return 0;
        if(dp[m][n]!=-1)
        return dp[m][n];
        return dp[m][n]=find(m-1,n,dp)+find(m,n-1,dp);
    }
}