class Solution {
    public int longestWPI(int[] hours) {
    
        int r =0;
        int sum=0;
    
        int ans =0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<hours.length){
            if(hours[r]>8)
            {
                sum+=1;
            }else
            sum-=1;

            map.putIfAbsent(sum,r);
            if(sum>0)
            ans = r+1;

            ans = Math.max(ans,r-map.getOrDefault(sum-1,r));
            r++;

        }
        return ans;
        
    }
}