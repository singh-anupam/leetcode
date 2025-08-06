class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int ans[] = new int[mat.length*mat[0].length];
        int m=mat.length;
        int n = mat[0].length;

        int r =0;
        int c =0;
        boolean upward = true;
        for(int i=0;i<m*n;i++){
            ans[i] = mat[r][c];
            if(upward){
                if(c==m-1){
                    r++;
                    upward=false;
                }else if(r==0){
                    c++;
                    upward =false;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r==n-1){
                    c++;
                    upward=true;
                }else if(c==0){
                    r++;
                    upward = true;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return ans;
        
    }
}