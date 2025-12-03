class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Long,Integer> map[] = new HashMap[n];
        for(int i =0;i<n;i++)
        {
            map[i] = new HashMap<>();
            for(int j=0;j<i;j++)
            {
                long diff = (long)nums[i]-nums[j];
                int cnt_At_j = map[j].getOrDefault(diff,0);
                result+=cnt_At_j;
                map[i].put(diff,map[i].getOrDefault(diff, 0) + cnt_At_j + 1);
            }
        }
        return result;
        
    }
}