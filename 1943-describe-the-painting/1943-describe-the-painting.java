class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
       TreeMap<Long,Long> map = new TreeMap<>();
    
        for(int seg[] :segments){
         map.put(seg[0]+0L,map.getOrDefault(seg[0]+0L,0L)+seg[2]);
        map.put(seg[1]+0L,map.getOrDefault(seg[1]+0L,0L)-seg[2]);
        }

        List<List<Long>> ans = new ArrayList<>();
        long start = 1L;   
        long sum = 0;
        for(long key : map.keySet()){
            
            if(sum>0){
                List<Long> l = new ArrayList<>();
                l.add(start);
                l.add(key);
                l.add(sum);
                
                ans.add(l);
            }
                sum+=map.get(key);
                start=key;
        }

        return ans;
        
    }
}