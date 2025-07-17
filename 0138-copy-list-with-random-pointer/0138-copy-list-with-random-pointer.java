/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
        Node root = head;
        Node chead = new Node(-1);
        while(head!=null){
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;

        }
        head=root;
       // print(head);
        head = root;
        chead = head.next;

        while(head!=null){
            Node node = head.next;
           
            if(head.random!=null)
            node.random = head.random.next;
             int val = node.random==null?-7:node.random.val;
            // System.out.println(val);
            
            head= node.next;
    
        }
        head = root;
        Node node= head.next;
        while(head!=null){
            head.next = node.next;
            head = head.next;
            if(head!=null)
            node.next = head.next;
            node = node.next;
        }
        // Node node = chead;
        // //  print(root);
        // // print(node);
        return chead;
        
    }
    private void print(Node node){
        while(node !=null){
            int val = node.random==null?-7:node.random.val;
            System.out.println(node.val+" "+val);
            node= node.next;
        }
    }
}