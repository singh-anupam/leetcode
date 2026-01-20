class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int dp[][] = new int[cost.length][cost.length+1];
        for(int arr[] : dp)
        Arrays.fill(arr,-1);
        return find(cost,time,0,cost.length,dp);
        
    }
    public int find(int cost[], int time[], int idx,int remaining, int dp[][])
    {
        if(remaining<=0)
        return 0;
        if(idx==cost.length)
        return 1000000000-1;
        if(dp[idx][remaining]!=-1)
        return dp[idx][remaining];
        long take = cost[idx]+find(cost,time,idx+1,remaining-1-time[idx],dp);
        long notTake = find(cost,time,idx+1,remaining,dp);
        return dp[idx][remaining]=(int)Math.min(take,notTake);
    }
}