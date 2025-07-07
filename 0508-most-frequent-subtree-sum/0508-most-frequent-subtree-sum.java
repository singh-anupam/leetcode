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
    public int[] findFrequentTreeSum(TreeNode root) {

        Map<Integer,Integer> map = new HashMap<>();
        find(root,map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int key : map.keySet())
        {
            if(map.get(key)>max)
            {
                list = new ArrayList<>();
                list.add(key);
                max = map.get(key);
            }
            else if(map.get(key)==max)
            {
                list.add(key);
            }
        }
        int arr[] = new int[list.size()];
        for(int i=0;i<arr.length;i++)
        arr[i]=list.get(i);

        return arr;
        
    }

    private int find(TreeNode root, Map<Integer,Integer> map)
    {
        if(root==null)
        return 0;
        int left = find(root.left,map);
        int right = find(root.right,map);
        int x = root.val+left+right;
        map.put(x,map.getOrDefault(x,0)+1);
        return x;
    }
}