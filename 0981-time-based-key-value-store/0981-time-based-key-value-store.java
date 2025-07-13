class TimeMap {
    class Pair{
        String val;
        int time;
        Pair(String val, int time ){
            this.val = val;
            this.time = time;
        }
        public String toString(){
            return val +" "+time;
        }
    }


    Map<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {

        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value,timestamp));
        map.put(key,list);
        //   printMap(map);
        
    }

   private void printMap(Map<String,List<Pair>> map){
        for(Map.Entry<String,List<Pair>> m :  map.entrySet()){
            System.out.println(m.getKey() +" "+m.getValue().toString());


        }
    }
    
    public String get(String key, int timestamp) {
        // System.out.println();
      
        if(!map.containsKey(key))
        return null;

        List<Pair> list = map.get(key);
        int l = 0;
        int r = list.size()-1;
        String ans = "";
        while(l<=r){
            int mid = l+(r-l)/2;
            Pair p = list.get(mid);
            // System.out.print(p.toString()+" -->");
            if(p.time>timestamp){
                r =mid-1;
            }
            else{
                ans = p.val;
                l=mid+1;
            }
        }
        return ans;

        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */