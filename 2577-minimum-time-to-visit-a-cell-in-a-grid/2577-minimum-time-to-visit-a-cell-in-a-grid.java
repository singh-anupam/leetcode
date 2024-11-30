class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1]>1 && grid[1][0]>1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int dirs[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        pq.offer(new int[]{grid[0][0],0,0});

        boolean vis[][] = new boolean[grid.length][grid[0].length];

        while(pq.size()>0){
            int rm[] = pq.poll();
            int time =rm[0];
            int x = rm[1];
            int y =rm[2];
            if(x==grid.length-1 && y==grid[0].length-1)
            return time;
            if(vis[x][y]) continue;
            vis[x][y]=true;
            for(int dir[] : dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                
                if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || vis[nx][ny])
                 continue;

                 int wait = (grid[nx][ny]-time)%2==0?1:0;
                 pq.offer(new int[]{Math.max(grid[nx][ny]+wait,time+1),nx,ny});


            }
        }
        return -1;
        
    }
}