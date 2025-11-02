class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l=matrix[0][0];
        int r = matrix[n-1][n-1];
      
        while(l<r){
            int mid = l+(r-l)/2;
            int count = getCount(matrix,mid);
            if(count<k){
                l=mid+1;
            }
            else
            r=mid-1;
        }

        return l;
        
    }

    private int getCount(int arr[][], int target){
        int count =0;
        int r= arr.length-1;
        int c = 0;
        while(c<arr[0].length && r>=0)
        {
            if(arr[r][c]<=target)
            {
                count+=r+1;
                c++;
            }else{
                r--;
            }

        }
        return count;

    }
}