class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        int dp[][] = new int[events.length][2];
        for(int arr[] : dp)
        Arrays.fill(arr,-1);

        
      return solve(events,0,0,dp);
        
    }

    private int solve(int arr[][], int pos, int count, int dp[][])
    {
        if(pos>=arr.length || count==2)
        return 0;
        if(dp[pos][count]!=-1)
        return dp[pos][count];
        int nextIdxIfTaken = find(arr,arr[pos][1]);
        int taken = arr[pos][2]+solve(arr,nextIdxIfTaken,count+1,dp);
        int notTaken = solve(arr,pos+1,count,dp);

        return dp[pos][count] =Math.max(taken,notTaken);



    }

    private int find(int arr[][], int target)
    {
        int l =0;
        int r =arr.length-1;
        int ans = arr.length;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid][0]>target)
            {
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}