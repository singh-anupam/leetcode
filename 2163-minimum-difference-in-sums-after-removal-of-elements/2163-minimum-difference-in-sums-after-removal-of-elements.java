class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a,b)->a-b);
        long max[] = new long[nums.length];
        long min[] = new long[nums.length];
        long sum =0;
        int n = nums.length/3;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxPq.offer(nums[i]);
            if(maxPq.size()>n){
                sum-=maxPq.poll();
            }
            min[i]=sum;
        } 
        sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum+=nums[i];
            minPq.offer(nums[i]);
            if(minPq.size()>n){
                sum-=minPq.poll();
            }
            max[i]=sum;

        }

        long ans = Long.MAX_VALUE;

        for(int i=n-1;i<2*n;i++){
            ans = Math.min(ans,min[i]-max[i+1]);
        }
        return ans;
        
    }
}