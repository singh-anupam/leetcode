class StockSpanner {
    Stack<Integer> stack;
    Map<Integer,Integer> map;
    int idx =0;

    public StockSpanner() {
        stack = new Stack<>();
        map = new HashMap<>();
        stack.push(-1);
        map.put(-1,Integer.MAX_VALUE);
        
    }
    
    public int next(int price) {
        map.put(idx,price);
        int count =0;
        while(stack.size()>0 && map.get(stack.peek())<=price)
        {
            stack.pop();
            
        }
        // if(stack.size()>0)
        count = idx-stack.peek();
        stack.push(idx);
        idx++;
        return count;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */