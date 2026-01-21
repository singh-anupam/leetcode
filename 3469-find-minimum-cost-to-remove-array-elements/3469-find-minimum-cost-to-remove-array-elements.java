class Solution {
    public int minCost(int[] nums) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int dp[][] = new int[nums.length][nums.length];
        for(int a[] : dp)
        Arrays.fill(a,-1);
        
        return find(nums,1,0,dp);

        // return sum;
        
    }

    private int find(int arr[], int sec, int first, int dp[][]){

        if(sec>=arr.length)
        return arr[first];
        if(sec==arr.length-1)
        return Math.max(arr[sec],arr[first]);

        if(dp[first][sec]!=-1)
        return dp[first][sec];

        int ans = Integer.MAX_VALUE;
        ans=Math.max(arr[first],arr[sec])+find(arr,sec+2,sec+1,dp);
        ans=Math.min(ans,Math.max(arr[sec],arr[sec+1])+find(arr,sec+2,first,dp));
        ans = Math.min(ans,Math.max(arr[first],arr[sec+1])+find(arr,sec+2,sec,dp));

        return dp[first][sec]=ans;
    }
}