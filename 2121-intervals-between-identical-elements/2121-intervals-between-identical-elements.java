class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer,Long> sumMap = new HashMap<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        long ans[] = new long[arr.length];
        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            if(!sumMap.containsKey(x)){
                sumMap.put(arr[i],0l);
                countMap.put(arr[i],0);
            }
            ans[i]+=i*countMap.get(arr[i])-sumMap.get(arr[i]);
            long y = sumMap.get(arr[i])+i;
            sumMap.put(arr[i],y);
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }
        sumMap = new HashMap<>();
        countMap= new HashMap<>();
        for(int i=arr.length-1;i>=0;i--){
            int x = arr[i];
            if(!sumMap.containsKey(x)){
                sumMap.put(arr[i],0l);
                countMap.put(arr[i],0);
            }
            ans[i]+=(arr.length-i-1)*countMap.get(arr[i])-sumMap.get(arr[i]);
            long y = sumMap.get(arr[i])+arr.length-i-1;
            sumMap.put(arr[i],y);
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }

        return ans;
         
       // return ans;
        
    }
}