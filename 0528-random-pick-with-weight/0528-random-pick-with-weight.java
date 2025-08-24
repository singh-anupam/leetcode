class Solution {
        int arr[];
    

    public Solution(int[] w) {
         arr =w;
        int sum =0;
        int x =0;
        for(int i : arr){
            sum+=i;
            arr[x++]=sum;
        }
        
    }
    
    public int pickIndex() {
        int  l =0;
        int r = arr.length-1;
        int idx = new Random().nextInt(arr[arr.length-1])+1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==idx)
            return mid;
            else if(arr[mid]<idx){
                l=mid+1;
            }else
            r=mid-1;
        }
        return r;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */