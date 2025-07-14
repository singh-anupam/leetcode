class Solution {
    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);
        int l = price[0];
        int r = price[price.length-1]-l/k;
        int ans =0;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isPossible(mid,k-1,price)){
                ans=Math.max(ans,mid);
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;

        
    }

    private boolean isPossible(int diff, int k, int arr[]){
    int prev =arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-prev>=diff){
                k--;
                prev=arr[i];
            }

        }
        return k<=0;
    }
}