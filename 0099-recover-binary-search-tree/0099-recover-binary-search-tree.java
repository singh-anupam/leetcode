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
    TreeNode a,b;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        find(root);
        // System.out.println(a.val+" "+b.val);
       int temp = a.val;
       a.val =b.val;
       b.val = temp;
        
    }
    private void find(TreeNode root)
    {
        if(root==null)
        return ;
        find(root.left);
        if(prev.val>root.val){
            if(a==null)
            {
                a=prev;
                b=root;
                // System.out.println(a.val + " "+prev.val);
            }
            else 
            {
                b=root;
            }

        }
        prev =root;
       
        find(root.right);
         
    }
}