class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int c : costs){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
            map.put(c,1);
            }
        }

        int ans = 0;

        for(int key: map.keySet()){
            int cnt = map.get(key);
            int totalCoins = cnt*key;
            if(totalCoins<=coins){
                coins-=totalCoins;
                ans+=cnt;
            }else{
                ans+=coins/key;
                return ans;
            }
        }
        return ans;

    
    }
}