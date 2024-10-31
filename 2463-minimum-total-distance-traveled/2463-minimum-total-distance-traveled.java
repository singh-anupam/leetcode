class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        Long dp[][] = new Long[robot.size()+1][factory.length+1];
        return find(robot,factory,0,0,dp);
        
    }

    private long find(List<Integer> robot, int factory[][], int i,int j, Long dp[][]){
        if(i>=robot.size())
        return 0L;
        if(j>=factory.length)
        return Long.MAX_VALUE;
        if(dp[i][j]!=null)
        return dp[i][j];

        long temp =0;
        long res = find(robot,factory,i,j+1,dp);
        for(int k=i;k<robot.size() && k-i+1<=factory[j][1];k++){
            temp+=Math.abs(robot.get(k)-factory[j][0]);
            long sum = find(robot,factory,k+1,j+1,dp);
            if(sum!=Long.MAX_VALUE){
                res=Math.min(res,temp+sum);
            }
        }

        return dp[i][j]=res;
    }
}