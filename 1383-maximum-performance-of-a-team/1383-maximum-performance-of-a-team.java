class Solution {
    int mod = 1_000_000_007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1] = efficiency[i];
        }
        long sum = 0;
        long ans = Integer.MIN_VALUE;

        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int i=n-1;i>=0;i--){
            sum+=arr[i][0];
            pq.offer(arr[i][0]);
            if(pq.size()>k){
                sum-=pq.poll();
            }
            ans = Math.max(ans,sum*arr[i][1]);
        }

        return (int)(ans%mod);
        
    }
}