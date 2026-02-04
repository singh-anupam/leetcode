class Solution {
    public int minCost(int[] nums, int k) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return find(nums,0,k,dp);
        
    }

    private int find(int arr[], int i, int k, int dp[]){
        if(i==arr.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];

        Map<Integer,Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int unique = 0;
        for(int j=i;j<arr.length;j++){
            int freq = map.getOrDefault(arr[j],0);
            if(freq==0)
            unique++;
            if(freq==1)
            unique--;
            map.put(arr[j],freq+1);
            ans = Math.min(ans,find(arr,j+1,k,dp)+(j-i+1-unique)+k);

        }
        return dp[i] =ans;
    }
}