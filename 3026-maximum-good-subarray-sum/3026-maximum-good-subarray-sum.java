class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Long> map = new HashMap<>();
        long sum = 0l,ans =Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.getOrDefault(nums[i],Long.MAX_VALUE)>sum){
                map.put(nums[i],sum);
            }
            sum+=nums[i];
            if(map.containsKey(nums[i]+k))
            ans = Math.max(ans,sum-map.get(nums[i]+k));
            if(map.containsKey(nums[i]-k)){
            ans = Math.max(ans,sum-map.get(nums[i]-k));
            }
        }

        return  ans==Long.MIN_VALUE?0l:ans;
        
    }
}