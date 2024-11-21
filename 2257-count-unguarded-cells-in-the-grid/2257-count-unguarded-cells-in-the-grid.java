class Solution {
    public int countUnguarded(int m, int n, int[][] gaurds, int[][] walls) {
        int arr[][] = new int[m][n];
        for(int gaurd[] : gaurds)
        {
            arr[gaurd[0]][gaurd[1]]=1;
        }
         for(int wall[] : walls)
        {
            arr[wall[0]][wall[1]]=2;
        }

        int dirs[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int gaurd[] : gaurds)
        {
            for(int dir[] : dirs){
            int nx = gaurd[0]+dir[0];
            int ny = gaurd[1]+dir[1];
            while(nx>=0 && ny>=0 && nx<m && ny<n && arr[nx][ny]<=0)
            {
                arr[nx][ny]=-1;
                nx+=dir[0];
                ny+=dir[1];
            }
        }



        }
        int count= 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
                if(arr[i][j]==0)count++;
            }
            System.out.println();
        }
        return count;
        
    }
}