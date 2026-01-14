class Solution {
    public int minCost(int[] nums) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int sum =0;
        Arrays.sort(nums);
        for(int i =nums.length-1;i>=0;i-=2){
            sum+=nums[i];
        }
        return sum;
        

        // return sum;
        
    }
}