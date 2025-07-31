class Solution {
    class Pair
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x=x;
            this.y=y;

        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]==1 )
        return -1;
        if(grid.length==1 && grid[0][0]==0)
        return 1;
        int dirx[] = new int[]{-1,0,1 };
        int diry[] = new int[]{ -1,0,1};
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(0,0));
        int ans =1;

        while(q.size()>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Pair rm = q.poll();
                for(int x : dirx)
                {
                    for(int y : diry)
                    {
                        if(x==0 && y==0)
                        continue;
                        int dx = rm.x+x;
                        int dy = rm.y+y;
                        if(dx<0 || dx>=grid.length || dy<0 || dy>=grid[0].length || grid[dx][dy]==1)
                        continue;
                        grid[dx][dy]=1;
                        q.offer(new Pair(dx,dy));
                        if(dx==grid.length-1 && dy ==grid[0].length-1)
                        return ans+1;
                    }
                }
            }
            ans++;
        }
        return -1;


        
    }
}