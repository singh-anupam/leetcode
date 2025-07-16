class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            int remain = sum%k;
            if(map.containsKey(remain))
            {
                if(i-map.get(remain)>1)
                    return true;
            }
            else
            map.put(remain,i);
            
            
        }
        return false;
    }
}