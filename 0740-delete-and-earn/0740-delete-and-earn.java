class Solution {
    public int deleteAndEarn(int[] nums) {
        int sum[] = new int[10010];
        int taken =0;
        int notTaken = 0;
        int max= 0;
        for(int num : nums){
            sum[num]+=num;
            max = Math.max(num,max);

        }
        for(int i=0;i<=max;i++){
            int temp = taken;
            taken = sum[i]+(i>0?notTaken:0);
            if(i>0)
            notTaken = Math.max(notTaken,temp);
        }

        return Math.max(taken,notTaken);
        
    }
}