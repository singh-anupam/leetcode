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
    List<Integer> list;
    TreeNode prev =null;
    int count =0, max=0;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        solve(root);
        int ans[] = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }

    private void solve(TreeNode root)
    {
        if(root==null)
        return;
        solve(root.left);
        if(prev!=null && prev.val ==root.val)
        count++;
        else
            count=1;
            prev =root;
        if(count==max)
        {          
            list.add(root.val);
        }
        if(count>max)
        {
            list = new ArrayList<>();
            list.add(root.val);
            max = count;
        }
        solve(root.right);

    }
}