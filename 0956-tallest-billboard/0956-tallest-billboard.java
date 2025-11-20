class Solution {
    public int tallestBillboard(int[] rods) {
        int dp[][] = new int[21][10003];

        for(int arr[] : dp)
        Arrays.fill(arr,-1);

        return find(rods,0,0,dp)/2;
        
    }

    private int find(int arr[], int idx, int diff, int dp[][]){
        if(idx>=arr.length){
            if(diff==0){
            return 0;
            }

            return Integer.MIN_VALUE;
        }
        if(dp[idx][5001+diff]!=-1)
        return dp[idx][5001+diff];
        int nothing  =  find(arr,idx+1,diff,dp);
        int left = arr[idx] + find(arr,idx+1,diff+arr[idx],dp);
        int right = arr[idx] + find(arr,idx+1,diff-arr[idx],dp);

        return dp[idx][diff+5001] = Math.max(nothing,Math.max(left,right));
    }

   
}