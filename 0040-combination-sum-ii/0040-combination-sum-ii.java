class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>subset = new ArrayList<>();
        dfs(subset,0,candidates,target,new ArrayList());
        return subset;
    }
    void dfs(List<List<Integer>>subset,int index,int candidates[],int target,List<Integer> current)
    {
        if(target<0)
            return;
        if(target==0  )
        {
            subset.add(new ArrayList(current));
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
           // if(i>0 && candidates[i]==candidates[i-1])
              //  continue;
            if (i != index && candidates[i] == candidates[i - 1]) { continue; }
            current.add(candidates[i]);
            dfs(subset,i+1,candidates,target-candidates[i],current);
            current.remove(current.size()-1);
        }
    }
}