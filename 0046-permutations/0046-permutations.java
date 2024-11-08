class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>subset = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        dfs(subset,nums,used,new ArrayList());
        return subset;
        
    }
    void dfs(List<List<Integer>> subset,int nums[],boolean used[],List<Integer> current)
    {
        if(current.size()==nums.length)
            subset.add(new ArrayList(current));
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==true)
                continue;
            current.add(nums[i]);
            used[i]=true;
            dfs(subset,nums,used,current);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
}