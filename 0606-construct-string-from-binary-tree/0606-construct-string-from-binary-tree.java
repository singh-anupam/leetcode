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
    public String tree2str(TreeNode root) {
        String result = find(root);
        return result;
    
        
    }

    private String find(TreeNode root){
        if(root==null)
        return "";
        String left = find(root.left);
        String right = find(root.right);
        if(root.left==null && root.right==null)
           return ""+root.val;
       if(root.left==null)
           return ""+root.val+"()"+"("+right+")";
       if(root.right==null)
           return ""+root.val+"("+left+")";
       return ""+root.val+"("+left+")"+"("+right+")";


    }
}