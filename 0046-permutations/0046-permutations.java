class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        find(nums,new ArrayList<>(),new boolean[nums.length]);
        return ans;
        
    }

    private void find(int arr[],  List<Integer> list, boolean vis[]){
        if(list.size()==arr.length)
        {
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(vis[i])
            continue;
            list.add(arr[i]);
            vis[i]=true;
            find(arr,list,vis);
            list.remove(list.size()-1);
            vis[i]=false;
        }

       
    }
}