class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long l = 0;
        long h = 0;
        for(int i : stations){
        h+=i;
        }
        h+=k;

        long ans = 0;
        while(l<=h){
            long mid = l+(h-l)/2;
            if(isPossible(stations,r,k,mid)){
                ans = mid;
                l = mid+1;
            }else
            h=mid-1;
        }
        return ans;
      
    }

    private boolean isPossible(int stations[], int r, long k, long target){
          int n = stations.length;
        long add[] = new long[n];
        long sum = 0;
        for(int i = 0;i<Math.min(r,n);i++){
            sum+=stations[i];
        }

        for(int i=0;i<n;i++){
           sum+=((i+r<n)?stations[i+r]:0);
           sum-=(i-r>0?stations[i-r-1]+add[i-r-1]:0);

            if(sum<target){
                long need = target-sum;
                if(need>k)
                return false;
                
                add[Math.min(n-1,i+r)]+=need;
                k-=need;
                sum+=need;
            }
        }
        return true;
        
    }
}