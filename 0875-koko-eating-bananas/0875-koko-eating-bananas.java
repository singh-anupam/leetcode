class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int r =1;
        for(int i : piles){
            r = Math.max(r,i);
        }
        int ans =r;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canEat(piles,h,mid)){
                ans =mid;
                r =mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
        
    }

    private boolean canEat(int arr[], int target, int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%k==0)
            count+=arr[i]/k;
            else
            count+=arr[i]/k+1;
        }
        return count<=target;
    }
}