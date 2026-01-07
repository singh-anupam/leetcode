class SummaryRanges {
TreeMap<Integer,Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
        
    }
    
    public void addNum(int value) {

        Map.Entry<Integer,Integer> floor = map.floorEntry(value);
        Map.Entry<Integer,Integer> cieling = map.ceilingEntry(value);
        
        if((floor!=null && floor.getKey()<=value && floor.getValue()>=value))
        return ;

        if((floor==null || value -floor.getValue()>1) && (cieling==null || cieling.getKey()-value >1))
        {
            map.put(value,value);
            return ;
        }

        if((floor!=null && value-floor.getValue()==1) && cieling!=null && cieling.getKey()-value==1)
        {
            map.put(floor.getKey(),cieling.getValue());
            map.remove(cieling.getKey());
            return ;
        }

        if((floor!=null && value-floor.getValue()==1) ){
            map.put(floor.getKey(),value);
            return ;

        }
        else{
            map.put(value,cieling.getValue());
            map.remove(cieling.getKey());

        }
        
    }
    
    public int[][] getIntervals() {
        int arr[][] = new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            arr[i][0]=entry.getKey();
            arr[i++][1]=entry.getValue();
        }

        return arr;
        
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */