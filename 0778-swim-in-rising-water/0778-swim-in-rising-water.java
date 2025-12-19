class Solution {
    public int swimInWater(int[][] grid) {

        int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int time[][] = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        for(int arr[] : time){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        time[0][0]=grid[0][0];
        while(q.size()>0){
            int rm[] = q.poll();
            for(int dir[] : dirs){
                int nx = rm[0]+dir[0];
                int ny = rm[1]+dir[1];
                if(isValid(nx,ny,grid) && time[nx][ny]>Math.max(time[rm[0]][rm[1]],grid[nx][ny]))
               { q.offer(new int[]{nx,ny});
                time[nx][ny] = Math.max(time[rm[0]][rm[1]],grid[nx][ny]);
               }
            }
        }

        return time[grid.length-1][grid.length-1];
        
    }

    private boolean isValid(int i, int j, int arr[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)
        return false;

        return true;
    }
}