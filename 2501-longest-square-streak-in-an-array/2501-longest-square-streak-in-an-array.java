class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max=0;
        for(int num : nums)
        {
            set.add(num);
        }
        for(int num : nums)
        {
            int count =0;
            long sqr =num;
            while( set.contains((int)sqr))
            {
                System.out.println(sqr);
                sqr = sqr*sqr;
                count++;
                if(sqr>100000)
                break;

            }
            max = Math.max(count,max);
        }
        return max<=1?-1:max;
        
    }
}