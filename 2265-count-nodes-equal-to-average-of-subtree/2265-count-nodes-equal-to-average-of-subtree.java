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
    int count =0;
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return count;
    }

    private int[] find(TreeNode root){
    if(root==null)
    return new int[]{0,0};

    int left[] = find(root.left);
    int right[] = find(root.right);
    int avg = (left[0]+right[0]+root.val)/(left[1]+right[1]+1);
    if(avg==root.val)
    count++;
    return new int[]{(left[0]+right[0]+root.val),(left[1]+right[1]+1)};
    }
}