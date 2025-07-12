class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       
       Map<Integer,Integer> map = new HashMap<>();
       int sum =0;
       int ans =0;
       map.put(0,1);
       for(int i =0;i<nums.length;i++){
        sum+=nums[i]%2;
        ans+=map.getOrDefault(sum-k,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
       }
       return ans;
       
        
    }

   
}