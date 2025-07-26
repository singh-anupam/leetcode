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
    int ans =0;
    public int maxSumBST(TreeNode root) {
        find(root);
        return ans;
    }

    private int[] find(TreeNode root)
    {
        if(root==null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0,1};
        }
        int left[] = find(root.left);
        int right[] = find(root.right);
        int sum = left[2]+right[2]+root.val;
        int x =0;
        
        if(left[3]==1 && right[3]==1 && root.val>left[1] && root.val<right[0]){
            ans = Math.max(sum,ans);
            x=1;
        }

        return new int[]{Math.min(left[0],root.val),Math.max(right[1],root.val),sum,x};

    }
}