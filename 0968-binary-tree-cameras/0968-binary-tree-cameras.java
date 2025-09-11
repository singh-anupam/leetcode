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
    int camera =0;
    public int minCameraCover(TreeNode root) {
        
        int cam = minCamera(root);
        if(cam==-1)
            camera++;
        return camera;
        
    }
    public int minCamera(TreeNode root)
    {
        if(root==null)
            return 1;
        int lcam =minCamera(root.left);
        int rcam = minCamera(root.right);
        if(lcam==-1 || rcam==-1)
        {
            camera++;
            return 0;
        }
        if(lcam ==0 || rcam==0)
            return 1;
        return -1;
    }
}