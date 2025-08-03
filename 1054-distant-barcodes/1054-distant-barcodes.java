class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int barcode : barcodes){
            map.put(barcode,map.getOrDefault(barcode,0)+1);
        }
        List<Integer> bucket[] = new ArrayList[barcodes.length+1];
        for(int key : map.keySet()){
            if(bucket[map.get(key)]==null)
            bucket[map.get(key)]=new ArrayList<>();
            bucket[map.get(key)].add(key);
        }
        int x =0;
        int ans[] = new int[barcodes.length];
        for(int i=bucket.length-1;i>=1;i--){
            if(bucket[i]==null){
                continue;
            }
            for(int num : bucket[i]){
                for(int time=1;time<=i;time++){
                    ans[x]=num;
                    x+=2;
                    if(x>=barcodes.length)
                    x=1;
                }
            }
        }

        return ans;

        
    }
}