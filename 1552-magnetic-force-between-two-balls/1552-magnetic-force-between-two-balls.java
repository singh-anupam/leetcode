class Solution {
    public int maxDistance(int[] positions, int m) {
        Arrays.sort(positions);
        int l =1;
        int n =positions.length;
        int r =positions[n-1];
        int ans=1;

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isPossible(positions,mid,m))
            {
                ans=mid;
                l =mid+1;

            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
        
    }

    private boolean isPossible(int arr[], int mid, int target)
    {
        int count=1;
        int prev = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-prev>=mid)
            {
                prev =arr[i];
                count++;
            }
            if(count==target)
            return true;

        }
        return false;
        
    }
}