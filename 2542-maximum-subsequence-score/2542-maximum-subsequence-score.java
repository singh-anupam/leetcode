class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int arr[][] = new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }

        long ans = Long.MIN_VALUE;
        long sum =0;

        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int a[]: arr){
            int min = a[1];
            pq.offer(a[0]);
            sum+=a[0];
            if(pq.size()>k)
            sum-=pq.poll();
            if(pq.size()==k)
            ans=Math.max(ans,sum*min);
        }

        return ans;
        
    }
}