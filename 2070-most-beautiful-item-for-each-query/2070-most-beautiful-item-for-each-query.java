class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int max = 0;
        for(int i=0;i<items.length;i++){
            max = Math.max(items[i][1],max);
            items[i][1]=max;
        }
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=find(items,queries[i]);
        }

        return ans;
        
        
    }

    private int find(int arr[][], int price)
    {
        int l =0;
        int r =arr.length-1;
        int ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid][0]<=price)
            {
                ans=arr[mid][1];
                l=mid+1;
            }else
            r=mid-1;
        }
        return ans;
    }
}