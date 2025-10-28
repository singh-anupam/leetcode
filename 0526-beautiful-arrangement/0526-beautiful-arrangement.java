class Solution {
    public int countArrangement(int n) {
        int dp[] = new int[1<<(n+1)];
        Arrays.fill(dp,-1);
        return find(n,n,dp,0);
    }

    private int find(int n, int idx, int dp[], int cacheIdx){
        if(idx==0)
        return 1;

        if(dp[cacheIdx]!=-1)
        return dp[cacheIdx];


        int ans = 0;
        for(int i=n;i>0;i--){
            if((cacheIdx & (1<<i))==0 && (i %idx==0 || idx%i==0)){
                cacheIdx=cacheIdx|(1<<i);
                ans+=find(n,idx-1,dp,cacheIdx);
                cacheIdx=cacheIdx|(0<<i);
            }
        }

        return dp[cacheIdx]=ans;

    }
}