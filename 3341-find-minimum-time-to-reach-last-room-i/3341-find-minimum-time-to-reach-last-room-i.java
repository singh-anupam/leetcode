class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int minTime[][] = new int[moveTime.length][moveTime[0].length];
        for(int dp[]: minTime)
        Arrays.fill(dp,Integer.MAX_VALUE); 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

        pq.offer(new int[]{0,0,0});
        int dirs[][] = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        while(pq.size()>0){
            int rm[] = pq.poll();
            int time = rm[2];
            int x = rm[0];
            int y = rm[1];
    
            for(int dir[] : dirs){
                int nx = dir[0]+x;
                int ny = dir[1]+y;
                if(isValid(nx,ny,minTime)){
                    int newTime = Math.max(time,moveTime[nx][ny])+1;
                    minTime[nx][ny]=newTime;
                    if(nx==moveTime.length-1 && ny==moveTime[0].length)
                    return newTime;
                    pq.offer(new int[]{nx,ny,newTime});
                }
            }

        }

        return minTime[minTime.length-1][minTime[0].length-1];
        
    }

    private boolean isValid(int i, int j, int arr[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=Integer.MAX_VALUE)
        return false;

        return true;
    }
}