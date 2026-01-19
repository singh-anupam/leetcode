class Solution {
    int mod = 1_000_000_007;
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer> h2p[] = new List[41];
        for(int i=0;i<=40;i++){
            h2p[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int hat : hats.get(i)){
                h2p[hat].add(i);
            }
        }
        int dp[][] = new int[1<<n][41];
        for(int d[] : dp)
        Arrays.fill(d,-1);

        return find(h2p,(1<<n)-1,0,1,dp);
        
    }

    private int find(List<Integer> h2p[], int allMask, int people, int hat, int dp[][]){
        if(people==allMask)
        return 1;
        if(hat>40)
        return 0;
        if(dp[people][hat]!=-1)
        return dp[people][hat];
        int ans = 0;
        ans = find(h2p,allMask,people,hat+1,dp);

        for(int p : h2p[hat]){
            if(((people >> p) & 1)==1)
            continue;
            ans+=find(h2p,allMask,people | (1<<p), hat+1,dp);
            ans%=mod;
        }
        return dp[people][hat]=ans;
    }
}