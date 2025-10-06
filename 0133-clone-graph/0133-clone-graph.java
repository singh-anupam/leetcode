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
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Integer,Node> map= new HashMap<>();
        map.put(node.val,new Node(node.val));
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            for(Node n: temp.neighbors)
            {
                if(!map.containsKey(n.val))
                {
                    q.add(n);
                    map.put(n.val,new Node(n.val));
                }
                map.get(temp.val).neighbors.add(map.get(n.val));
                    
            }
        }
        return map.get(node.val);
        
    }
}