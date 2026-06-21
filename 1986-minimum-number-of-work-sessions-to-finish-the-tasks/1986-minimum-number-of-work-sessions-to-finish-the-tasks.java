class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
       int mask =0;
       int total = (1<<tasks.length);
       int dp[][] = new int[total+1][sessionTime+1];
    //    for(int arr[] : dp)
    //    Arrays.fill(arr,-1);
       return find(tasks,mask,0,sessionTime, dp);
    }

    private int find(int arr[], int mask,int sum, int total, int dp[][]){
        if(mask==((1<<arr.length))-1)
        return 1;

        if(dp[mask][sum]!=0)
        return dp[mask][sum];

        int min = arr.length;

        for(int i=0;i<arr.length;i++){
            if((mask & (1<<i)) !=0)
            continue;
            int newMask = mask|(1<<i);
            if(sum+arr[i]<=total)
             min= Math.min(min,find(arr,newMask,sum+arr[i],total,dp));
            //  System.out.println(newMask);
              min= Math.min(min,1+find(arr,newMask,arr[i],total,dp));

        }

        return dp[mask][sum]=min;
    }
}
