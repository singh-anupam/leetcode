class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<points.length;i++){
            int x =points[i][0];
            int y = points[i][1];
            pq.offer(new int[]{(int)Math.sqrt(x*x + y*y),i});
            if(pq.size()>k)
            pq.poll();
        }

        int ans[][] = new int[k][];
        for(int i=0;i<k;i++){
            ans[i]=points[pq.poll()[1]];
        }

        return ans;
        
    }
}