class Solution {
    int mod =1_000_000_007;
    public int knightDialer(int n) {
        int arr[][] = new int[10][];
        arr[0] =new int[]{4,6};
        arr[1]=new int[]{6,8};
        arr[2] = new int[]{7,9};
        arr[3] = new int[]{8,4};
        arr[4] = new int[]{9,0,3};
        arr[5] = new int[]{};
        arr[6] = new int[]{1,7,0};
        arr[7] = new int[]{2,6};
        arr[8]= new int[]{1,3};
        arr[9] = new int[]{4,2};
        
        int sum =0; 
        int dp[][] = new int[n+1][10];
        for(int d[] :dp)
        Arrays.fill(d,-1);
        for(int i=0;i<10;i++){
            sum=(sum+dfs(arr,n-1,i,dp))%mod;

        }

        return sum;
        
    }
    private int dfs(int  arr[][], int n,int i,int dp[][]){
        if(n==0)
        return 1;
        if(dp[n][i]!=-1)
        return dp[n][i];
        int sum =0;
        for(int nbr : arr[i]){
            sum =(sum+dfs(arr,n-1,nbr,dp))%mod;

        }
        return dp[n][i] =sum;
    }
}