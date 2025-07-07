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
    int ans = 0;
    int x;
    public int kthSmallest(TreeNode root, int k) {
        x=k;
       find(root);
       
       return ans;
        
    }
    private void find(TreeNode root)
    {
        if(root==null)
        return ;
        find(root.left);
        x--;
        if(x==0)
        ans = root.val;
        
        find(root.right);

    }
}