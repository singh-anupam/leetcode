class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int prefix[][] = new int[mat.length+1][mat[0].length+1];

        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+mat[i-1][j-1];
                // System.out.print(prefix[i][j]+" ");
            }
            // System.out.println();
        }

        int left =0;
        int right  = Math.min(mat.length,mat[0].length)-1;
        int ans =0;

        while(left<=right){
            int mid = left+(right-left)/2;
            int minSum =Integer.MAX_VALUE;
            for(int r =1;r+mid<prefix.length;r++){
                for(int c=1;c+mid<prefix[0].length;c++){
                    int sum = prefix[r+mid][c+mid]-prefix[r-1][c+mid]-prefix[r+mid][c-1]+prefix[r-1][c-1];
                    minSum = Math.min(sum,minSum);
                    System.out.print(minSum+" ");
                }
                System.out.println();
            }

            if(minSum<=threshold)
            {
                ans = mid;
                left=mid+1;
            }else
            right=mid-1;
        }

        return ans;
        
    }
}