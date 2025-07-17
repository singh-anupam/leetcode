class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        ans.add(new ArrayList<>(list));
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=list.size();j++){
                if(j==0 || j==list.size()){
                    temp.add(1);
                }
                else
                temp.add(list.get(j-1)+list.get(j));

            }
            ans.add(temp);
            list = temp;
        }
        return ans;
        
    }
}