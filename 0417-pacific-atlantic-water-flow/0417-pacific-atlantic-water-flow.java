class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        boolean vis1[][] = new boolean[heights.length][heights[0].length];
        boolean vis2[][] = new boolean[heights.length][heights[0].length];

        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++){
                if(i==0 || j==0){
                    pacific.offer(new int[]{i,j});
                    vis1[i][j]=true;
                }
                if(i==heights.length-1 || j==heights[0].length-1){
                    atlantic.offer(new int[]{i,j});
                    vis2[i][j]=true;
                }
            }
        }
        // print(vis1);
        // print(vis2);
        int dirs1[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int dirs2[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        traverse(pacific,vis1,heights,dirs1);
        // print(vis1);
        traverse(atlantic,vis2,heights,dirs2);
        // print(vis2);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<vis1.length;i++){
            for(int j=0;j<vis1[0].length;j++){
                if(vis1[i][j] && vis2[i][j])
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;


        
    }

    private void print(boolean vis[][]){
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void traverse(Queue<int[]> q, boolean vis[][], int arr[][], int dirs[][]){

        

        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
            int rm[] = q.poll();
            for(int dir[] : dirs){
                int nx = rm[0]+dir[0];
                int ny = rm[1]+dir[1];
                if(isValid(arr, vis, rm[0], rm[1],nx, ny)){
                    //  System.out.print(nx+","+ny+"  ");
                    // if(!vis[nx][ny])
                     vis[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                   
                }
            }
            
            }
            System.out.println();
        }

    }

    private boolean isValid(int arr[][], boolean vis[][], int x, int y, int nx, int ny){
        if(nx<0 || ny<0 || nx>=arr.length || ny>=arr[0].length || vis[nx][ny] || arr[nx][ny]<arr[x][y])
        return false;

        return true;

    }
}