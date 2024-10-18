class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int maxOr =0;
        for(int num :  nums)
        {
            maxOr=maxOr|num;
            
        } 
        
       return find(nums,0,0,maxOr);
        
    }
    
    private int find(int nums[], int i,int curOr, int maxOr)
    {
        
            
        if(curOr==maxOr && i ==nums.length)
            return 1;
        if(i==nums.length)
            return 0;
        
        int take = find(nums,i+1,nums[i]|curOr,maxOr);
        int notTake = find(nums,i+1,curOr,maxOr);
        return take+notTake;
    }
}