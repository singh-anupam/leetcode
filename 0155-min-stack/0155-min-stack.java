class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            min=val;
            return;
        }
        if(val>min){
            st.push((long)val);
        }
        else{
            long newVal = 2L*val - min;
            st.push(newVal);
            min=val;
        }
    }

    public void pop() {
        long x = st.pop();
        if(x<min){
            min = 2*min-x;
        }
    }

    public int top() {
        long x = st.peek();
        if(x<min){
            return (int)min;
        }
        return (int)x;
    }

    public int getMin() {
        return (int)min;
    }
}