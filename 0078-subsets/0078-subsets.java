class Solution {

    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans =new ArrayList<>();

        dfs(nums,0,new ArrayList<>());
        return ans;
    }
    private void dfs(int arr[], int pos, List<Integer> list){
        if(pos==arr.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        dfs(arr,pos+1,list);
        list.add(arr[pos]);
        dfs(arr,pos+1,list);
        list.remove(list.size()-1);
    }
}