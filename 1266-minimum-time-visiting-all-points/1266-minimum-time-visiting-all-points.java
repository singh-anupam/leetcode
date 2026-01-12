class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int prev[] = new int[]{points[0][0],points[0][1]};
        int count =0;
        for(int i=1;i<points.length;i++){
            count+=Math.max(Math.abs(points[i][0]-prev[0]),Math.abs(points[i][1]-prev[1]));
            prev = points[i];

        }

        return count;
        
    }
}