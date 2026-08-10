class Solution {
    public int minDistance(String word1, String word2) {

        int dp[][] = new int[word1.length()][word2.length()];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }

        return find(word1,word2,0,0,dp);
        
    }

    private int find(String s, String w, int i, int j, int dp[][]){
        if(i==s.length() && j==w.length())
        return 0;
        if(i ==s.length() ){
            return w.length()-j;
        }
        if(j==w.length()){
            return s.length()-i;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==w.charAt(j)){
            return dp[i][j] =find(s,w,i+1,j+1,dp);
        }
        int insert = 1+ find(s,w,i,j+1,dp);
        int replace = 1+ find(s,w,i+1,j+1,dp);
        int delete = 1 + find(s,w,i+1,j,dp);

        return dp[i][j] =Math.min(replace,Math.min(insert,delete));
    }
}