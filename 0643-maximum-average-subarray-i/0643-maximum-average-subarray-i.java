class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }

        double avg = sum/k;
        int l=0;
        int r= k;
        while(r<nums.length){
            sum-=nums[l++];
            sum+=nums[r++];
            avg = Math.max(avg,sum/k);
        }
        return avg;
        
    }
}