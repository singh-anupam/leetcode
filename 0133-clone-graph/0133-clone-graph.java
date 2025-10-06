/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     public Node cloneGraph(Node node){
    boolean vis[] =new boolean[101];
    Map<Integer,Node> map = new HashMap<>();
    return cloneGraph2(node,vis,map);
     }
    public Node cloneGraph2(Node node,boolean vis[], Map<Integer,Node> map) {
        if(node==null)
        return null;
        if( vis[node.val])
        return map.get(node.val);

        Node root = new Node(node.val);
        map.put(node.val,root);
        vis[root.val]=true;
        List<Node> nbrs  = root.neighbors;
        for(Node nbr : node.neighbors){
          
            nbrs.add(cloneGraph2(nbr,vis,map));
        }
        return root;
    }
}