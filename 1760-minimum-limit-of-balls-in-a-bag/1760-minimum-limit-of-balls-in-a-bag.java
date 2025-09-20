class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int l=1;
        int r =1;
        for(int num : nums){
            r = Math.max(r,num);
        }

        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(nums,mid, maxOperations)){
                ans= mid;
                r = mid-1;
            }else
            l=mid+1;
        }

        return ans;
        
    }

    private boolean isPossible(int arr[], int total, int target){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count+=arr[i]/total;
            int d = arr[i]%total;
            if(d>0)
            count++;
            if(d==0)
            count--;

            if(count>target)
            return false;
        }
        return true;
    }
}