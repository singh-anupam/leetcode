class NumMatrix {

    int arr[][];

    public NumMatrix(int[][] matrix) {
        arr = matrix;
        arr = prefix(matrix);

        printMatrix(arr);
        
    }

    private int[][] prefix(int matrix[][]){
        int arr[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 && j==0)
                arr[i][j]=matrix[i][j];
                else if(i==0)
                    arr[i][j]=arr[i][j-1]+matrix[i][j];
                else if(j==0)
                    arr[i][j] = matrix[i][j]+matrix[i-1][j];
                else
                    arr[i][j]=matrix[i][j]-arr[i-1][j-1]+arr[i-1][j]+arr[i][j-1];
                
            }
        }
        return arr;
    }

    private void printMatrix(int arr[][]){

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            System.out.print(arr[i][j]+" ");
             System.out.println();
        }
       

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = arr[row2][col2]-arr[row1-1][col2]-arr[row2][col1-1]+arr[row1-1][col1-1];
        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */