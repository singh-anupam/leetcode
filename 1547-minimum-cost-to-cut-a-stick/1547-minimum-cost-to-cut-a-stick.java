class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp = new int[cuts.length][cuts.length];
        for(int arr[]:dp)
        Arrays.fill(arr,-1);
        return find(cuts,0,n,0,cuts.length-1);
        
    }
    public int find( int cuts[], int start, int end, int left, int right)
    {
        if(left>right)
        return 0;
        if(dp[left][right]!=-1)
        return dp[left][right];
        int sum=Integer.MAX_VALUE;
        for(int i = left; i<=right;i++)
        {
        int first = find(cuts,start,cuts[i],left,i-1);
        int second = find(cuts,cuts[i],end,i+1,right);
        sum=Math.min(sum,end-start+first+second);

        }
        return dp[left][right]=sum;
    }
}