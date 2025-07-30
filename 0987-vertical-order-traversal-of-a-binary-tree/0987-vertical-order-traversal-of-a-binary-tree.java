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
    List<List<Integer>> ans;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        traverse(root,0,map);
        int len = max-min+1;
        for(int i=0;i<len;i++){
            ans.add(new ArrayList<>());
        }
        //  System.out.println(min+" "+max);
        min =Math.abs(min);
       
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
            // System.out.println(list);
             List<Integer> l = ans.get(key+min);
             l.addAll(list);
        }
        return ans;
    }

    private void traverse(TreeNode root, int level, Map<Integer,List<Integer>> map)
    {
        if(root==null)
        return ;
        min = Math.min(min,level);
        max = Math.max(max,level);
        List<Integer> list = map.getOrDefault(level,new ArrayList<>());
        list.add(root.val);
        map.put(level,list);
        traverse(root.left,level-1,map);
        traverse(root.right,level+1,map);
    }
}