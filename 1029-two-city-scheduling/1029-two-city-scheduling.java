class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int dp[][][]=new int[costs.length][costs.length][costs.length];
        for(int i=0;i<costs.length;i++)
        {
            for(int j=0;j<costs.length;j++)
            {
              int ar[]= dp[i][j];
              Arrays.fill(ar,-1);
                
            }
        }
        
        return find(costs,0,0,0,dp);
        
    }
    private int find(int arr[][], int pos, int countA, int countB, int dp[][][])
    {
        if(pos==arr.length)
            return 0;
        int n = arr.length/2;
        if(dp[pos][countA][countB]!=-1)
            return dp[pos][countA][countB];
        if(countA>=n)
          return dp[pos][countA][countB]=arr[pos][1]+find(arr,pos+1,countA,countB+1,dp);
        if(countB>=n)
            return dp[pos][countA][countB]=arr[pos][0]+find(arr,pos+1,countA+1,countB,dp);
        
         return dp[pos][countA][countB]=Math.min(arr[pos][0]+find(arr,pos+1,countA+1,countB,dp),arr[pos][1]+find(arr,pos+1,countA,countB+1,dp));
     
         
    }
}