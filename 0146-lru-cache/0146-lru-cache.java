class Node
{
    Node prev,next;
    int key,val;
    Node(int k, int v)
    {
        this.key = k;
        this.val = v;
    }
}

class LRUCache {
    int cap;
    Node head,tail;
    Map<Integer,Node> map;
    int count;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        count=0;
        
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        int val = node.val;
        deleteNode(node);
        addNode(key,val);
    //    print();
        return val;
        
    }
    
    public void put(int key, int value) {
        
          if(map.containsKey(key))
        {
            Node delNode = map.get(key);
           deleteNode(delNode);
            
        }
        
        Node node = addNode(key,value);
                
      
        
        if(count>cap)
        {
            deleteNode(tail.prev);
        }
        
     //   print();
        
        
        
    }
    
    public Node addNode(int key, int val)
    {
        count++;
        Node node  = new Node(key,val);
        Node temp = head.next;
        head.next=node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
        map.put(key,node);
      
        return node;
    }
    
    public void deleteNode(Node node)
    {
        count--;
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next =null;
        node.prev =null;
    }
    
    public void print()
    {
          System.out.println();
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.key+" : "+temp.val+" , ");
            temp=temp.next;
        }
        System.out.println();
        temp = tail;
          while(temp!=null)
        {
            System.out.print(temp.key+" : "+temp.val+" , ");
            temp=temp.prev;
        }
        
    }
        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */