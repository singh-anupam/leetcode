class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

         find(k,n,1,new ArrayList<>());
         return ans;
        
    }

    private void find(int k, int sum,int idx, List<Integer> list){
        if(sum<0)
        return ;
        if(k==0){
            if(sum==0){
                List<Integer> l = new ArrayList<>(list);
                Collections.sort(l);
                if(!ans.contains(l))
                {
                    ans.add(new ArrayList<>(l));
                }
            }
            return ;
        
            
        }

        for(int i=idx;i<=9;i++){
            if(list.contains(i))
            continue;
            list.add(i);
            find(k-1,sum-i,i+1,list);
            list.remove(list.size()-1);
        }
    }
}