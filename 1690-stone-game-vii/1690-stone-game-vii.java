class Solution {
    public int stoneGameVII(int[] stones) {
        int dp[][] = new int[stones.length][stones.length];
        for(int arr[] : dp)
        Arrays.fill(arr,-1);

        int sum = 0;
        for(int i : stones)
        sum+=i;
        return find(stones,dp,0,stones.length-1,sum);
    }

    private int find(int arr[], int dp[][], int start, int end, int sum)
    {
        if(start>end)
        return 0;

        if(dp[start][end]!=-1)
        return dp[start][end];

        int fromLeft = sum-arr[start]-find(arr,dp,start+1,end,sum-arr[start]);
        int fromRight = sum-arr[end]-find(arr,dp,start,end-1,sum-arr[end]);

        return dp[start][end] = Math.max(fromLeft,fromRight);
    }
}