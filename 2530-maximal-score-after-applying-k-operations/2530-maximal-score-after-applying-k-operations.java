class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num :  nums)
            pq.offer(num);
        while(k-->0)
        {
            int x = pq.poll();
            sum+=x;
            if(x%3!=0)
                
            pq.offer((x/3)+1);
            else
                pq.offer(x/3);
            
            
            
        }
        
        return sum;
    }
}