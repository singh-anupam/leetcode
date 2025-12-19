class Solution {
    public int shortestPath(int[][] grid, int k) {

        int dirs[][] = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        int vis[][] = new int[m][n];
        for(int arr[] : vis)
        Arrays.fill(arr,Integer.MAX_VALUE);

        vis[0][0]=0;

        int count =0;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int rm[] = q.poll();
                if(rm[0]==m-1 && rm[1]==n-1)
                return count;

                for(int dir[] : dirs){
                    int nx = rm[0]+dir[0];
                    int ny = rm[1]+dir[1];
                    if(isValid(nx,ny,grid)){
                        int nk = rm[2]+grid[nx][ny];
                        if(nk>k || vis[nx][ny]<=nk)
                        continue;

                        q.offer(new int[]{nx,ny,nk});
                        vis[nx][ny]=nk;
                        
                    }
                }

                

            }
            count++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int arr[][]){
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length)
        return false;
        return true;
    }
}