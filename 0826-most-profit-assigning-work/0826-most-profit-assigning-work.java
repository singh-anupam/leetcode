class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int arr[][] = new int[difficulty.length][2];
        for(int i=0;i<profit.length;i++){
            arr[i][0]=difficulty[i];
            arr[i][1]=profit[i];
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            arr[i][1]=Math.max(max,arr[i][1]);
            max = arr[i][1];
        }
        int ans =0;

      for(int i=0;i<worker.length;i++){
        ans+=solve(arr,worker[i]);
      }

      return ans;
        
    }

    private int solve(int arr[][], int target)
    {
        int l =0;
        int r = arr.length-1;
        int ans =0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid][0]<=target){
                ans=arr[mid][1];
                l=mid+1;
            }else
            r=mid-1;
        }

        return ans;
        
    }
}