class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x =x;
            this.y = y;
        }
    }

    int dirs[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();
        int freshCount =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                queue.offer(new Pair(i,j));
                if(grid[i][j]==1)
                freshCount++;
            }
        }

int minReq = 0;
        while(queue.size()>0){
            int size =queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                for(int dir[]: dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(grid,nx,ny)){
                        queue.offer(new Pair(nx,ny));
                        grid[nx][ny]=2;
                        freshCount--;
                    }
                }
            }
            minReq++;
        }
        return freshCount==0?minReq-1:-1;


        
    }

    private boolean isValid(int grid[][], int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || grid[i][j]==2)
        return false;

        return true;
    }
}