class MKAverage {

    class Node implements Comparable<Node>{
        int val;
        int idx;
        Node(int val, int idx){
            this.val = val;
            this.idx=idx;
        }

        public int compareTo(Node node){
            return this.val==node.val?this.idx-node.idx:this.val-node.val;
        }
    }

    TreeSet<Node> set;
    Queue<Node> q;
    int m ;
    int k;
    int sum;
    int idx;
    Node kLeft;
    Node kRight;

    public MKAverage(int m, int k) {
        set = new TreeSet<>();
        this.m = m;
        this.k = k;
        q = new LinkedList<>();
        this.sum =0;
        this.idx= 0;

        
    }
    
    public void addElement(int num) {
        Node node = new Node(num,idx++);
        addNode(node);
        remove();
        if(idx==m){
            init();
        }
        
    }

    private void init(){
        int i =0;
        for(Node node : set){
            if(i<k-1);
            else if(i==k-1)
            kLeft = node;
            else if(i<m-k)
            sum+=node.val;
            else if(i==m-k)
            {
                kRight = node;
                return;
            }

            i++;


        }
    }

    private void remove(){
        if(q.size()<=m)
        return ;
        Node node = q.poll();
        set.remove(node);
       
        if(node.compareTo(kLeft)<=0){
            
            kLeft = set.higher(kLeft);
            sum-=kLeft.val;
        }else if(node.compareTo(kRight)>=0){
            
            kRight = set.lower(kRight);
            sum-=kRight.val;
        }else{
            sum-=node.val;
        }
         
    }

    private void addNode(Node node){
        q.offer(node);
        set.add(node);
        if(q.size()<=m)
        return ;
        if(node.compareTo(kLeft)<0){
            sum+=kLeft.val;
            kLeft=set.lower(kLeft);
        }
        else if(node.compareTo(kRight)>0){
            sum+=kRight.val;
            kRight = set.higher(kRight);
        }
        else{
            sum+=node.val;
        }
      
    }
    
    public int calculateMKAverage() {
        return q.size()<m?-1:(sum/(m-(2*k)));
        
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */