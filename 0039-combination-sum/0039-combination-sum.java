class Solution {
    List<List<Integer>>ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates,target,new ArrayList<>(),0);
        return ans;



        
    }
    private void find(int arr[], int target,List<Integer> list,int pos){
        if(target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0)
        return ;

        for(int i=pos;i<arr.length;i++){
           if(target-arr[pos]<0)
           continue;
           
        list.add(arr[i]);
        find(arr,target-arr[i],list,i);
        list.remove(list.size()-1);

        }
        
    }

        
}