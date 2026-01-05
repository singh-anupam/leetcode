class Solution {
    public int numTrees(int n) {

        int dp[][] = new int[n+1][n+1];
        for(int arr[] : dp)
        Arrays.fill(arr,-1);

        return find(1,n,dp);
        
    }

    private int find(int start, int end, int dp[][]){
        if(start>end)
        return 1;

        if(dp[start][end]!=-1)
        return dp[start][end];
     
        int sum = 0;
        for(int i=start;i<=end;i++){

            int numLeft = find(start,i-1,dp);
            int numRight = find(i+1,end,dp);
            sum+=numLeft*numRight;

        }
        return dp[start][end] =sum;
    }
}