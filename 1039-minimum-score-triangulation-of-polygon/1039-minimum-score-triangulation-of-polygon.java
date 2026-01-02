class Solution {
    public int minScoreTriangulation(int[] values) {
        int dp[][] = new int[values.length][values.length];
        for(int arr[] : dp)
        Arrays.fill(arr,-1);
        return find(values,0,values.length-1,dp);
    }

    private int find(int arr[], int i, int k, int dp[][]){
        if(k-i<=1)
        return 0;
        if(dp[i][k]!=-1)
        return dp[i][k];
        int min =Integer.MAX_VALUE;
        for(int j=i+1;j<k;j++){
            int score = arr[i]*arr[j]*arr[k] + find(arr,i,j,dp) + find(arr,j,k,dp);
            min = Math.min(min,score);
        }

        return dp[i][k]=min;
    }
}