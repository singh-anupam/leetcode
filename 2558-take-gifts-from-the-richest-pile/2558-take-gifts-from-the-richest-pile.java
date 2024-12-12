class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int gift: gifts){
            pq.offer(gift);
        }
        for(int i=0;i<k;i++)
        {
            int rm =pq.poll();
            int sqrt = (int)(Math.sqrt(rm));
            pq.offer(sqrt); 
        }
        long sum=0;
        while(pq.size()>0)
        {
            sum+=pq.poll();
        }
        return sum;
        
    }
}