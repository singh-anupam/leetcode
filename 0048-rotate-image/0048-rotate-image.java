class Solution {
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
       // printMatrix(matrix);
        inverse(matrix);
      //  printMatrix(matrix);
        
    }
    
    private void transpose(int matrix[][])
    {
        int n = matrix.length;
       for(int j=0;j<n;j++)
       {
           for(int i=0;i<j;i++)
           {
               if(i==j)
                   continue;
               int val = matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=val;
           }
       }
    }
    
    private void inverse(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
        {
            int x = matrix.length-1;
            for(int j=0;j<x;j++)
            {
                int val = matrix[i][j];
               matrix[i][j]=matrix[i][x];
               matrix[i][x--]=val;
            }
        }
    }
    
    
    private void printMatrix(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}