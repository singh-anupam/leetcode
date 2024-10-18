class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int maxOr =0;
        for(int num :  nums)
        {
            maxOr=maxOr|num;
            
        } 
        
        int dp[][] = new int[nums.length][maxOr+1];
        for(int arr[] : dp)
            Arrays.fill(arr,-1);
        
       return find(nums,0,0,maxOr,dp);
        
    }
    
    private int find(int nums[], int i,int curOr, int maxOr, int dp[][])
    {
        
            
        if(curOr==maxOr && i ==nums.length)
            return 1;
        if(i==nums.length)
            return 0;
        
        if(dp[i][curOr]!=-1)
            return dp[i][curOr];
        
        int take = find(nums,i+1,nums[i]|curOr,maxOr,dp);
        int notTake = find(nums,i+1,curOr,maxOr,dp);
        return dp[i][curOr]=take+notTake;
    }
}