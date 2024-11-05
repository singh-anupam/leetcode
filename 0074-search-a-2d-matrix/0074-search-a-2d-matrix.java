class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l =0;
        int n = matrix.length;
        int m = matrix[0].length;
        int r = (m*n)-1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            int row = mid/m;
            int col = mid%m;
            System.out.println("*****"+r+" "+l+" "+mid);
            System.out.println(row+" "+col+" "+matrix[row][col]);
            if(matrix[row][col]==target)
            return true;
            else if(matrix[row][col]>target)
            r=mid-1;
            else
            l=mid+1;
            
        }
        return false;
        
    }
}