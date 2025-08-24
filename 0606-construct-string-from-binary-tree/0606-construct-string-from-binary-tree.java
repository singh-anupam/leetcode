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
    String str = "";
    public String tree2str(TreeNode root) {
        
     return  traverse(root);
   //     return str;
    }
   public String traverse (TreeNode root)
    {
        if(root==null)
        {
        
            return "";
            
        }
      //  str+=root.val;
    
       String lstr = traverse(root.left);
       String rstr =traverse(root.right);
     
       if(root.left==null && root.right==null)
           return ""+root.val;
       if(root.left==null)
           return ""+root.val+"()"+"("+rstr+")";
       if(root.right==null)
           return ""+root.val+"("+lstr+")";
       return ""+root.val+"("+lstr+")"+"("+rstr+")";
           
       
        //str+=")";
        
            
    }
}