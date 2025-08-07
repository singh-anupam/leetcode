class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1)
        return cost[0];

        int first = cost[cost.length-2];
        int sec =cost[cost.length-1];
        for(int i=cost.length-3;i>=0;i--){
            int x = cost[i]+Math.min(first,sec);
            sec =first;
            first =x;

        }
        return Math.min(first,sec);
        
    }
}