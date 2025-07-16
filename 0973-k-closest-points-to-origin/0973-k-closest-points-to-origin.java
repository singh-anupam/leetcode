class Solution {
    class MyCompare implements Comparator<Double>{
        
        public int compare(Double x, Double y){
            return y>x?1:0;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq =new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<points.length;i++){
            int x =points[i][0];
            int y = points[i][1];
            pq.offer(new double[]{Math.sqrt(x*x + y*y),i});
            if(pq.size()>k)
            pq.poll();
        }

        int ans[][] = new int[k][];
        for(int i=0;i<k;i++){
            int pos = (int)pq.poll()[1];
            ans[i]=points[pos];
        }

        return ans;
        
    }
}