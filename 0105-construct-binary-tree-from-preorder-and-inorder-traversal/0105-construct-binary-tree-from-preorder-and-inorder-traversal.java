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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n =preorder.length;
        return construct(preorder,0,n-1, inorder,0,n-1);
        
    }
    private TreeNode construct(int preorder[], int pS, int pEn, int inorder[], int inS, int inE)
    {
        if(pS>pEn)
            return null;
        int pos = inS;
        int cnt =0;
        while(inorder[pos]!=preorder[pS])
        {
            pos++;
            cnt++;
        }
        TreeNode root = new TreeNode(preorder[pS]);
        root.left = construct(preorder,pS+1,pS+cnt,inorder,inS,pos-1);
        root.right =construct(preorder,pS+cnt+1,pEn,inorder,pos+1,inE);
        return root;
                                              
        
    }
}