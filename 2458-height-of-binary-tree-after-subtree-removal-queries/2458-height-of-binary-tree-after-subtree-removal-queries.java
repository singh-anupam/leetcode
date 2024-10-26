/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
       // Map<Integer,Integer> map = new HashMap<>();
        int height[] = new int[100001];
        int level[] =new int[100001];
        int maxHeight[][] = new int[100001][2];
        for(int i=0;i<100001;i++)
        {
            maxHeight[i][1]=-1;
            maxHeight[i][0]=-1;
        }
       // Arrays.fill(maxHeight)
       int max =  dfs(root,0,height,level,maxHeight);
      
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int val = queries[i];
            // if(maxHeight[level[val]][0]==height[val] && maxHeight[level[val]][1]==0 )
            // ans[i]=level[val]-1;
            // else
            ans[i]=level[val]+(height[val]==maxHeight[level[val]][0]?maxHeight[level[val]][1]:maxHeight[level[val]][0]);
          System.out.println("****"+val+" "+level[val]+" "+height[val]+" "+maxHeight[level[val]][0]+" "+maxHeight[level[val]][1]);
   
        }

        return ans;
       
    }

    private int dfs(TreeNode root,int level, int height[], int levelHeight[], int maxHeight[][])
    {
        if(root==null)
        return -1;

        levelHeight[root.val]=level;
        int left = dfs(root.left,level+1,height,levelHeight,maxHeight);
        int right = dfs(root.right,level+1,height,levelHeight,maxHeight);
        height[root.val]=Math.max(left,right)+1;
        if(maxHeight[level][0]<height[root.val])
        {
            maxHeight[level][1]=maxHeight[level][0];
            maxHeight[level][0]=height[root.val];

        }
        else if(maxHeight[level][1]<height[root.val])
        {
            maxHeight[level][1]=height[root.val];
        }
        System.out.println(root.val+" "+level+" "+height[root.val]+" "+levelHeight[root.val]+" "+maxHeight[level][0]+" "+maxHeight[level][1]);
        
        return Math.max(left,right)+1;
    }
}