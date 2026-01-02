class Solution {
    public int palindromePartition(String s, int k) {
        int dp[][] = new int[s.length()][k+1];

        for(int d[] : dp)
        Arrays.fill(d,-1);

        return find(s,0,k,0,dp);
        
    }

    private int find(String s, int idx , int k, int partition, int dp[][]){
        if(idx==s.length()){
            if(partition==k)
            return 0;
            return Integer.MAX_VALUE;
        }

        if(partition>=k)
        return Integer.MAX_VALUE;

        if(dp[idx][partition]!=-1)
        return dp[idx][partition];

        int min = Integer.MAX_VALUE;

        for(int i=idx;i<s.length();i++){
            int res = find(s,i+1,k,partition+1,dp);
            int cnt = res==Integer.MAX_VALUE?Integer.MAX_VALUE:getCount(s,idx,i)+res;
            min = Math.min(min,cnt);
        }
        return dp[idx][partition]=min;
    }

    private int getCount(String s, int l, int r){
        int count =0;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--))
            count++;
        }
        return count;
    }
}