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
    class Pair
    {
        int siblingSum =0;
        TreeNode node;
        Pair(TreeNode node, int sum)
        {
            this.node = node;
            this.siblingSum = sum;
        }
    }
    public TreeNode replaceValueInTree(TreeNode root) {

        if(root==null)
        return root;

        Queue<Pair> q = new LinkedList<>();
    root.val =0;
    q.offer(new Pair(root,0));
    int sum=0;
        while(q.size()>0)
        {
            
            int size = q.size();
            int total=0;
            for(int i=0;i<size;i++)
            {
                Pair rm = q.poll();
                System.out.println(rm.siblingSum+" "+sum);
                rm.node.val=sum-rm.siblingSum;
                if(rm.node.left!=null)
                {
                    int x = rm.node.right==null?0:rm.node.right.val;
                    q.offer(new Pair(rm.node.left,x+rm.node.left.val));
                    total+=rm.node.left.val;
                }
                if(rm.node.right!=null)
                {
                    int x = rm.node.left==null?0:rm.node.left.val;
                    q.offer(new Pair(rm.node.right,x+rm.node.right.val));
                     total+=rm.node.right.val;
                }
            }
            sum=total;
            System.out.println("********");

        }
        return root;
        
    }
}