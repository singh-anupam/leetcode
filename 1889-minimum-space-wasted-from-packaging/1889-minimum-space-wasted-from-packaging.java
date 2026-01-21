class Solution {
    long mod = (long)1e9+7;
    public int minWastedSpace(int[] packages, int[][] boxes) {

        Arrays.sort(packages);
        long sumOfPackages = 0L;
        for(int i : packages){
            sumOfPackages+=i;
        }
        long inf = (long)1e11;
        long res=inf;

        for(int arr[] : boxes){
            Arrays.sort(arr);
            if(packages[packages.length-1]>arr[arr.length-1])
                continue;
            long curSum=0;
            long i=0;
            long j=0;
            for(int box: arr){
                j = binarySearch(packages,box+1);
                curSum+=(j-i)*box;
                i=j;
            }

            res=Math.min(res,curSum);
            
        }

        return res>=inf?-1:(int)((res-sumOfPackages)%mod);
        
    }

    private int binarySearch(int arr[],int target){
        int l =0;
        int r = arr.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}