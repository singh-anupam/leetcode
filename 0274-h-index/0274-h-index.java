class Solution {
    public int hIndex(int[] citations) {
        int arr[] = new int[10001];
        for(int i=0;i<citations.length;i++){
            arr[citations[i]]++;
        }

        int sum =0;
        int ans =0;

        for(int i=arr.length-1;i>=0;i--){
            sum+=arr[i];
            if(arr[i]>0 && i<=sum)
            return i;

        }
        return ans;
        
    }
}