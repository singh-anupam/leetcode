class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        int count =0;
        int prev = nums[0][1];
        for(int i=1;i<nums.length;i++){
            if(nums[i][0]<prev){
                count++;
                prev = Math.min(nums[i][1],prev);
            }else
            prev = nums[i][1];
        }

        return count;
        
    }
}