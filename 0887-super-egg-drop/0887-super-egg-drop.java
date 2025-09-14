class Solution {
    public int superEggDrop(int k, int n) {
        
        int dp[][] = new int[n+1][k+1];
        
        for(int arr[] : dp)
        {
            Arrays.fill(arr,-1);
        }
        
        return find(n,k,dp);
    }
    
    private int find(int floors, int eggs, int dp[][])
    {
        if(floors==1 || floors==0 || eggs==1)
            return floors;
        if(dp[floors][eggs]!=-1)
            return dp[floors][eggs];
        int min = Integer.MAX_VALUE;
        int left =1;
        int right =floors;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int eggBreak = find(mid-1,eggs-1,dp);
            int notBreak = find(floors-mid,eggs,dp);
            if(eggBreak>notBreak)
                right=mid-1;
            else
                left=mid+1;
            min = Math.min(min,1+Math.max(eggBreak,notBreak));
            
        }
        return dp[floors][eggs]=min;
    }
}