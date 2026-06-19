class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans =0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans = Math.max(ans,dfs(matrix,i,j,dp));
            }
        }

        return ans;
        
    }

    private int dfs(int arr[][], int i, int j, int dp[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)
        return 0;
        if(dp[i][j]>0)
        return dp[i][j];

        int left=0,right=0,up=0,down=0;

        if(i<arr.length-1 && arr[i+1][j]>arr[i][j])
        down = dfs(arr,i+1,j,dp);
         if(i>0 && arr[i-1][j]>arr[i][j])
        up = dfs(arr,i-1,j,dp);
         if(j<arr[0].length-1 && arr[i][j+1]>arr[i][j])
        right = dfs(arr,i,j+1,dp);
         if(j>0 && arr[i][j-1]>arr[i][j])
        left = dfs(arr,i,j-1,dp);

        return dp[i][j] = Math.max(Math.max(left,right),Math.max(up,down))+1;
    }
}