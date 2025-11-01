class Solution {
    public int getMaximumGold(int[][] grid) {
//         int n =grid.length;
//         int m =grid[0].length;
//         int sum=0;
//         for(int j =m-2;j>=0;j--)
//         {
//             for(int i=0;i<n;i++)
//             {
//                 if(i==0)
//                 {
//                     grid[i][j]+=Math.max(grid[i][j+1],grid[i+1][j+1]);
//                 }
//                else if(i==n-1)
//                 {
//                     grid[i][j]+=Math.max(grid[i][j+1],grid[i-1][j+1]);
//                 }
//                 else
//                     grid[i][j]+=Math.max(grid[i-1][j+1],Math.max(grid[i][j+1],grid[i+1][j+1]));
//                 System.out.println(grid[i][j]);sum=Math.max(grid[i][0],sum);
//             }
            
//         }
//         return sum;
                int n =grid.length;
        int m =grid[0].length;
        int ans = Integer.MIN_VALUE;
        boolean visited[][]=new boolean[n][m];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
             ans=Math.max(ans, traverse(grid, i,j,visited));
        }
        return ans;
    }
        
        public int traverse(int [][]nums, int i, int j, boolean visited[][])
        {
            if(i<0 || j<0 || i>=nums.length || j>= nums[0].length || nums[i][j]==0 || visited[i][j])
            {
                return 0;
            }
            
            visited[i][j]=true;
            int down = traverse(nums,i+1,j,visited);
            int up = traverse(nums,i-1,j,visited);
            int left = traverse(nums,i,j-1,visited);
            int right = traverse(nums,i,j+1,visited);
            visited[i][j]=false;
            return nums[i][j]+Math.max(Math.max(left,right),Math.max(up,down));
        }
        
        
        
    
}