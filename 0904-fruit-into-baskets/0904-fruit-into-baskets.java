class Solution {
    public int totalFruit(int[] fruits) {

        int l=0;
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<fruits.length;i++)
        {
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);

            while(map.size()>2)
            {
                int rm = map.get(fruits[l]);
                rm--;
                if(rm==0)
                {
                    map.remove(fruits[l++]);
                    break;
                }
                map.put(fruits[l++],rm);

               

            }

            ans = Math.max(i-l+1,ans);
        }
        return ans;
        
    }
}