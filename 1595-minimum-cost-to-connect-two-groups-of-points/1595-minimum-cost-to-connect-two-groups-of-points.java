class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {

        int dp[][][] = new int[cost.size()][cost.get(0).size()][1<<cost.get(0).size()];
        for(int arr[][] : dp){
            for(int b[] : arr)
            Arrays.fill(b,-1);
        }
        
        return find(0,0,0,cost,dp);
        
    }

    private int find(int i, int j, int mask, List<List<Integer>> cost,int dp[][][]){

        if(i>=cost.size()){
            if(mask==(1<<cost.get(0).size())-1)
            return 0;
            return Integer.MAX_VALUE;
        }

        if(j==cost.get(0).size())
        return Integer.MAX_VALUE;

        if(dp[i][j][mask]!=-1)
        return dp[i][j][mask];
        int x = find(i+1,0,mask|(1<<j),cost,dp);
        int y = find(i,j+1,mask|(1<<j),cost,dp);
        int take = x==Integer.MAX_VALUE?x:x+cost.get(i).get(j);
        int take2 = y==Integer.MAX_VALUE?y:y+cost.get(i).get(j);
        int notTake = find(i,j+1,mask,cost,dp);

        return dp[i][j][mask]= Math.min(Math.min(take,take2),notTake);
    }
}