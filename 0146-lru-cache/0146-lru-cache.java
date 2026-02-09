class LRUCache {

    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node root;
    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        size = 0;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        update(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        Node node;
        if(!map.containsKey(key)){
            node = new Node(key,value);
            node.prev = head;
            node.next = head.next;
            map.put(key,node);
            size++;
        }
        node= map.get(key);
        node.val = value;
        update(node);
        if(size>capacity){
            Node lastNode = delteLastNode();
            map.remove(lastNode.key);
            size--;
        }
        
    }

    private void update(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.next.prev = node;
        node.prev =head;
        head.next = node;
    }
    private Node delteLastNode(){
        Node node = tail.prev;
         node.prev.next = tail;
         tail.prev = node.prev;
         return node; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */