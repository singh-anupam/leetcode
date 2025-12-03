class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long,Integer> map[] = new HashMap[nums.length];
        int ans =0;
        for(int i=0;i<nums.length;i++){
            map[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                long diff = (long)(nums[i]-nums[j]);
                int cnt = map[j].getOrDefault(diff,0);
                ans+=cnt;
                map[i].put(diff,map[i].getOrDefault(diff,0)+cnt+1);
            }
        }
        return ans;
        
    }
}