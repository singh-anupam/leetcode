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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size()>0)
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode rm = q.poll();
                if(rm.left!=null)
                q.offer(rm.left);
                if(rm.right!=null)
                q.offer(rm.right);
                list.add(rm.val);

            }
            ans.add(0,list);
        }

        return ans;
        
    }
}