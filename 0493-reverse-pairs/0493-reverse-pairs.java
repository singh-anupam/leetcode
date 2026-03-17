class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }

    private int mergesort(int arr[], int l, int r){
        if(l>=r)
        return 0;
        int mid = l+(r-l)/2;
        int left = mergesort(arr,l,mid);
        int right = mergesort(arr,mid+1,r);
        int curr = countPair(arr,l,mid,r);
        merge(arr,l,mid,r);
        return left+ right +curr;

    }

    private int countPair(int arr[], int l, int mid, int r){
        int count=0;
        int k = mid+1;
        while(l<=mid){
            while(k<=r && arr[l]>2l*arr[k])k++;
            count+=(k-(mid+1));
            l++;
        }
        return count;
    }

    private void merge(int arr[], int l, int mid, int r){
        int temp[] = new int[r-l+1];
        int k =mid+1;
        int left =l;
        int i=0;
        while(l<=mid && k<=r){
            if(arr[l]<=arr[k])
            temp[i++]=arr[l++];
            else
            temp[i++]=arr[k++];
        }
        while(l<=mid){
            temp[i++]=arr[l++];
        }
        while(k<=r){
            temp[i++]=arr[k++];
        }

        for(int x =0;x<temp.length;x++){
            arr[left++]=temp[x];
        }
    }
}