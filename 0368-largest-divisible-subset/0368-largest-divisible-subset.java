class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer>list = new ArrayList<>();
        
        List<Integer> dp[] = new ArrayList[nums.length];
        
        
        
        Arrays.sort(nums);
        
        for(int i =0;i<nums.length;i++)
        {
            dp[i]=new ArrayList<>();
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(dp[i].size()<dp[j].size())
                    dp[i]=new ArrayList<>(dp[j]);
                   
                }
            }
        dp[i].add(nums[i]);
            if(list.size()<dp[i].size())
                list = new ArrayList<>(dp[i]);
        }
        return list;
        
       
        
        
        
    }
  
}