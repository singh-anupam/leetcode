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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        find(root);
        return sum;


        
    }

    private int find(TreeNode root){
        if(root==null)
        return 0;
        int left = find(root.left);
        int right = find(root.right);
        int curr = (left<0?0:left) +(right<0?0:right) +root.val;
        sum = Math.max(sum,curr);
        if(curr<0)
        return 0;
        return root.val+Math.max(left,right);
    }
}