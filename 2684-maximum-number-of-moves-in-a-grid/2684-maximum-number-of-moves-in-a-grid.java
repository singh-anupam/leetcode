class Solution {
    public int maxMoves(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        int ans= 0;

        for(int i = 0;i<grid[0].length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
              //  System.out.println(j+" "+i);
              int max=0; 
                if(i==0)
                {
                    dp[j][i]=1;
                    continue;
                }
                else if(j==0)
                {
                    
                    int left = grid[j][i-1]<grid[j][i]?dp[j][i-1]:0;
                    int leftDown = grid[j+1][i-1]<grid[j][i]?dp[j+1][i-1]:0;
                     max =Math.max(left,leftDown);
                    
                }
                else if(j==grid.length-1){
                     int left = grid[j][i-1]<grid[j][i]?dp[j][i-1]:0;
                    int leftUp =  grid[j-1][i-1]<grid[j][i]?dp[j-1][i-1]:0;
                    max=Math.max(left,leftUp);

                }
                else
                {
                   int left = grid[j][i-1]<grid[j][i]?dp[j][i-1]:0;
                    int leftDown = grid[j+1][i-1]<grid[j][i]?dp[j+1][i-1]:0;
                    int leftUp = grid[j-1][i-1]<grid[j][i]?dp[j-1][i-1]:0;
                    max=Math.max(left,Math.max(leftUp,leftDown));


                }
                dp[j][i]=max==0?0:max+1;
             //   System.out.print(i+" "+j+" "+"####" +dp[j][i]+" ");
                ans = Math.max(dp[j][i],ans);

            }
        //    System.out.println();

          
        }
        // printMatrix(grid);
        // System.out.println();

        printMatrix(dp);
          return ans==0?0:ans-1;
        
    }
    private void printMatrix(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}