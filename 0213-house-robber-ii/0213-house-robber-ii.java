class Solution {
    public int rob(int[] nums) {

        int a = find(nums,0,nums.length-1);
        int b = find(nums,1,nums.length);
        return Math.max(a,b);
        
    }
    private int find(int arr[], int s, int e){
        int take =0;
        int notTake =0;
        for(int i=s;i<e;i++){
            int temp = take;
            take = arr[i]+notTake;
            notTake = Math.max(notTake,temp);
        }
        return Math.max(take,notTake);

    }
}