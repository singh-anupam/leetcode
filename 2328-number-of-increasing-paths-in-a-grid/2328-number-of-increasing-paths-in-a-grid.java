class Solution {
   int mod = (int)(1e9+7);
    int dirs[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int countPaths(int[][] grid) {
        
        int dp[][] = new int[grid.length][grid[0].length];

        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                count=(count+dfs(grid,i,j,dp))%mod;
            }
        }
        return count;
    }

    private int dfs(int arr[][], int i, int j, int dp[][]){
        if(dp[i][j]>0)
        return dp[i][j];
        int count =1;
        for(int dir[]: dirs){
            int nx = i+dir[0];
            int ny = j+dir[1];
            if(isValid(arr,nx,ny) && arr[nx][ny]>arr[i][j])
            count = (count+dfs(arr,nx,ny,dp))%mod;

        }
        return dp[i][j]=(count)%mod;
    }

    private boolean isValid(int arr[][],int x, int y){
        if(x<0 || x>=arr.length || y<0 || y>=arr[0].length )
        return false;

        return true;
    }
}