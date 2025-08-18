class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int peak = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]<arr[(Math.min(mid+1,arr.length-1))]){
                l=mid+1;
            }else{
                 peak = mid;
                r=mid-1;
               
            }
        }
        return peak;
        
    }
}