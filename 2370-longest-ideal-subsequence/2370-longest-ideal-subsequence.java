class Solution {
    public int longestIdealString(String s, int k) {
        int ans =0;
        int dp[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int max =0;
            for(int j=Math.max(0,i-k-1);j<i;j++){
                if(Math.abs(s.charAt(i)-s.charAt(j))<=k){
                    max = Math.max(dp[j],max);
                }
                
            }
            dp[i]=max+1;
            ans = Math.max(ans,dp[i]);
        }

        return ans;
        
    }
}