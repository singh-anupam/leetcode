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
    public String getDirections(TreeNode root, int startValue, int destValue) {

        List<String> srcPath = new ArrayList<>();
        List<String> dstPath = new ArrayList<>();
        
        dfs(root, startValue, srcPath);
        dfs(root, destValue, dstPath);
        // System.out.println(srcPath);
        // System.out.println(dstPath);
        int commonPath = 0;
        while(commonPath<srcPath.size() && commonPath<dstPath.size() && srcPath.get(commonPath).equals(dstPath.get(commonPath)))
        commonPath++;

        String ans = "";

        for(int i=0;i<srcPath.size()-commonPath;i++){
            ans+="U";

        }

        for(int i=commonPath;i<dstPath.size();i++){
            ans+=dstPath.get(i);
        }

        return ans;

        
    }

    private boolean dfs(TreeNode root, int startValue, List<String> list){
        if(root==null)
        return false;

        if(root.val==startValue)
        return true;
        list.add("L");
        if(dfs(root.left,startValue,list))
        return true;

        list.remove(list.size()-1);
        list.add("R");

        if(dfs(root.right,startValue,list))
        return true;
        list.remove(list.size()-1);

        return false;
    }
}