class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();

         find(nums,new ArrayList<>());

         return ans;
        


    }

    private void find(int arr[], List<Integer> list)
    {
        if(list.size()==arr.length)
        {
            ans.add(new ArrayList(list));
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i]))
            continue;

            list.add(arr[i]);

            find(arr,list);
            list.remove(list.size()-1);



        }
    }
}