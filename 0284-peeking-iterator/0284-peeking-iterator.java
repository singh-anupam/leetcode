// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    // ArrayList<Integer> list =new ArrayList<>();
    Queue<Integer> q;

	public PeekingIterator(Iterator<Integer> it) {

	    // initialize any member here.
        q =new LinkedList<>();
        while(it.hasNext()){
            q.offer(it.next());
        }


	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return q.peek();
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        return q.poll();
	    
	}
	
	@Override
	public boolean hasNext() {
        return q.size()!=0;
	    
	}
}