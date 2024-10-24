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
class CBTInserter {

    TreeNode root;
    Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {

        this.root= root;
        q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0)
        {
            TreeNode rm = q.peek();
            if(rm.left!=null)
            {
                q.offer(rm.left);
            }
            if(rm.right!=null)
            {
                q.offer(rm.right);
                q.poll();
            }
            if(rm.left!=null || rm.right!=null)
            break;
        }

        
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode top = q.peek();
        if(top.left==null)
        {
            top.left = node;
           

        }else{
            top.right =node;
            q.poll();
        }
        q.offer(node);
        return top.val;
    
    }
    
    public TreeNode get_root() {
        return root;
        
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */