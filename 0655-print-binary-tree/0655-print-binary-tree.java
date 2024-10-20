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
    class Pair
    {
        int col;
        int row;
        TreeNode node;
        Pair(TreeNode node,  int row, int col)
        {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<String>> printTree(TreeNode root) {
        
       int depth =  depth(root);
        int max = (int)Math.pow(2,depth)-1;
        
        int d = depth-1;
        
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0,max/2));
        List<List<String>> ans = new ArrayList<>();
        
        
        while(queue.size()>0)
        {
            int size = queue.size();
            List<String> list = new ArrayList<>();
            for(int i =0;i<max;i++)
                list.add("");
            for(int i=0;i<size;i++)
            {
                Pair rm = queue.poll();
                int r = rm.row;
                int c = rm.col;
                list.set(c,rm.node.val+"");
               // System.out.println("col "+c);
                
                if(rm.node.left!=null)
                {
                  //  System.out.println("left "+(c-(int)Math.pow(2,d-r-1)));
                    queue.offer(new Pair(rm.node.left,r+1,c-(int)Math.pow(2,d-r-1)));
                }
                if(rm.node.right!=null)
                {
                 //   System.out.println("right "+(c+(int)Math.pow(2,d-r-1)));
                    queue.offer(new Pair(rm.node.right,r+1,c+(int)Math.pow(2,d-r-1)));
                }
            }
            ans.add(list);
        }
        
        return ans;
        
        
        
    }
    
    private int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }
    
    
}