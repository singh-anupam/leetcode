class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int l =0;
        int h = m-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            int max = 0;
            for(int i=0;i<n;i++){
                if(mat[i][mid]>mat[max][mid]){
                    max=i;
                }
            }

            int left = mid==0?-1:mat[max][mid-1];
            int right =mid==m?-1:mat[max][mid+1];
            if(mat[max][mid]>left && mat[max][mid]>right)
            return new int[]{max,mid};

            else if(mat[max][mid]<left)
            h=mid-1;
            else
            l=mid+1;
        }

        return new int[]{-1,-1};
        
    }

}