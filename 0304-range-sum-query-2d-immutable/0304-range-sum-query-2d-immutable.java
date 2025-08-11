class NumMatrix {

    int arr[][];

    public NumMatrix(int[][] matrix) {
        arr = matrix;
        arr = prefix(matrix);

        printMatrix(arr);
        
    }

    private int[][] prefix(int matrix[][]){
        int arr[][] = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
             
                    arr[i][j]=matrix[i-1][j-1]-arr[i-1][j-1]+arr[i-1][j]+arr[i][j-1];
                
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

        // int x = row1==0?0:arr[row1-1][col2];
        // inty = col1==0?0:arr[row2][col1-1];


        int sum = arr[row2+1][col2+1]-arr[row1][col2+1]-arr[row2+1][col1]+arr[row1][col1];
        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */