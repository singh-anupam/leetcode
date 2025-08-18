class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l =0;
        int r = arr.length;
        int peak =arr[0];
        while(l<r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]<arr[Math.min(mid+1,arr.length-1)])
            {
                l=mid+1;
               
                
            }
            else
            {
                r=mid;
                 peak = mid;
            }
        }
        
        return peak;
    }
}