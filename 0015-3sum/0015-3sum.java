class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i =0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1] )
                continue;
            int l =i+1;
            int r = nums.length-1;
            int sum = nums[i];
            while(l<r)
            {
                if((nums[l]+nums[r]+sum)==0)
                {
                    List<Integer> list =Arrays.asList(nums[i],nums[l],nums[r]);
                    ans.add(list);
                 
                }
                if((nums[l]+nums[r]+sum)>0)
                    r--;
                else{
                     l++;
                
                while(l>0 && nums[l]==nums[l-1] && l<r)
                    l++;
                   
                }
                
              
                
            }
        }
        
        return ans;
        
    }
    
    private boolean isSame(List<Integer> l1, List<Integer> l2)
    {
        for(int i=0;i<=2;i++)
            if(l1.get(i)!=l2.get(i))
                return false;
        return true;
    }
}