class Solution {
    public int maxProfit(int k, int[] prices) {

        int dp[][][] = new int[prices.length][k+1][2];

        return find(prices,k,0,0,dp);
        
    }

    private int find(int arr[], int k, int pos, int isBought, int dp[][][]){
        if(pos==arr.length || k==0)
        return 0;
        int buy =0;
        if(isBought==1)
        buy = arr[pos] + find(arr,k-1,pos+1,0,dp);
        else
         buy = -arr[pos]+find(arr,k,pos+1,1,dp);

        int skip = find(arr,k,pos+1,isBought,dp);

        return dp[pos][k][isBought] = Math.max(buy,skip);



    }
}