class Solution {
    public int countSquares(int[][] matrix) {
        int count =0;
        int m = matrix.length;
        int n =matrix[0].length;
        for(int i=matrix.length-2;i>=0;i--)
        {
            for(int j =matrix[0].length-2;j>=0;j--)
            {
                if(matrix[i][j]==1)
                { matrix[i][j]=Math.min(matrix[i+1][j],Math.min(matrix[i][j+1],matrix[i+1][j+1]))+1;}
              
               // System.out.print(matrix[i][j]+" ");
            }
         //   System.out.println();
        }
      
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                count+=matrix[i][j];
        }
        
        return count;
    }
}