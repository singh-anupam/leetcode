class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        return find(price,special,needs,0);
        
    }

    private int find(List<Integer> price, List<List<Integer>> special,List<Integer> needs, int idx){

        if(idx==special.size())
        {
            int cost = 0;
            for(int i=0;i<price.size();i++){
                cost+=needs.get(i)*price.get(i);
            }
            return cost;
        }

        int ans = Integer.MAX_VALUE;
        List<Integer> updateNeeds = new ArrayList<>();

        ans = Math.min(ans,find(price,special,needs,idx+1));
        if(canBuy(needs,special.get(idx))){
            for(int i=0;i<needs.size();i++)
            updateNeeds.add(needs.get(i)-special.get(idx).get(i)); 
            ans= Math.min(ans,special.get(idx).get(special.get(0).size()-1)+find(price,special,updateNeeds,idx));
        }

        return ans;        
        
    }

    private boolean canBuy(List<Integer> needs, List<Integer> given){
        for(int i=0;i<needs.size();i++){
            if(needs.get(i)<given.get(i))
            return false;
        }

        return true;
    }
}