class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int max = 0;
          int dp[][] = new int[n][k];
            for(int arr[] : dp){
                Arrays.fill(arr,-1);
            }
        for(int i=0;i<n;i++)
        {
          
            max = Math.max(max, find(n,k,stayScore,travelScore,i,0, dp));
        }

        return max;
        
    }

    private int find(int n, int k, int stay[][], int arr[][], int i, int d, int dp[][]){
        if(d>=k)
        return 0;

        if(dp[i][d]!=-1)
        return dp[i][d];

        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans,stay[d][i]+find(n,k,stay,arr,i,d+1,dp));
        for(int m=0;m<n;m++){
            if(m==i)
            continue;
            ans = Math.max(ans,arr[i][m]+find(n,k,stay,arr,m,d+1,dp));
        }

        return dp[i][d]=ans;

    }
}