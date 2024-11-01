class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res = Math.max(res,dfs(matrix,i,j,dp));

            }
        }
        return res;
        
    }

    private int dfs(int arr[][], int i, int j,int dp[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)
        return 0;
        if(dp[i][j]>0)
        return dp[i][j];

        int top =0,right=0,left =0,down=0;
        if(i>0 && arr[i][j]<arr[i-1][j])
        top = dfs(arr,i-1,j,dp);
         if(j>0 && arr[i][j]<arr[i][j-1])
        left = dfs(arr,i,j-1,dp);
         if(j<arr[0].length-1 && arr[i][j]<arr[i][j+1])
        right = dfs(arr,i,j+1,dp);
         if(i<arr.length-1 && arr[i][j]<arr[i+1][j])
        down = dfs(arr,i+1,j,dp);

        return dp[i][j]=Math.max(left,Math.max(right,Math.max(top,down)))+1;

    }
}