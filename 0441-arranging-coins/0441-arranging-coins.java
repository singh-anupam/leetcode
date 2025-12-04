class Solution {
    public int arrangeCoins(int n) {
        int l =0;
        int r = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            long cnt = (long)mid*(mid+1)/2;
            if(cnt==n)
            return mid;
            else if(cnt>n)
            r=mid-1;
            else
            l=mid+1;
        }
        return r;
        
    }
}