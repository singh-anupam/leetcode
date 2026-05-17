class Solution {
    public int[] maxValue(int[] nums) {
        int max = nums[0];
        int left[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            left[i]=max;
        }

        // Stack<Integer> stack = new Stack<>()
        max = nums.length-1;

        for(int i=nums.length-1;i>=0;i--){
            if(left[i]>nums[max]){
                left[i]=Math.max(left[i],left[max]);
                if(nums[i]<nums[max])
                max =i;
            }else{
                max = i;
            }
        }

        return left;

        // return nums;

    }
}