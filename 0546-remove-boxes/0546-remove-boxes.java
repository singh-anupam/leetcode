class Solution {
    public int removeBoxes(int[] boxes) {
        int dp[][][] = new int[boxes.length][boxes.length][boxes.length+1];
        for(int i=0;i<boxes.length;i++){
            for(int j=0;j<boxes.length;j++){
                for(int k=0;k<=boxes.length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return find(boxes,0,boxes.length-1,0,dp);
        
    }

    private int find(int arr[], int l, int r, int streak, int dp[][][]){
        if(l>r)
        return 0;
        if(l==r)
        return (streak+1)*(streak+1);
        if(dp[l][r][streak]!=-1)
        return dp[l][r][streak];

        int newStreakBegin  = find(arr,l+1,r,0,dp)+(streak+1)*(streak+1);
        int oldStreak =0;
        for(int i=l+1;i<=r;i++){
            if(arr[i]==arr[l]){
                oldStreak = Math.max(oldStreak,find(arr,l+1,i-1,0,dp)+find(arr,i,r,streak+1,dp));

            }
        }

        return dp[l][r][streak] = Math.max(newStreakBegin,oldStreak);
    }
}