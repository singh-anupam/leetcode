class Solution {
    public int minGroups(int[][] intervals) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        for(int arr[] : intervals)
        {
            if(pq.size()>0 && pq.peek()<arr[0])
                pq.poll();
            
            pq.offer(arr[1]);
        }
        
        return pq.size();
        
    }
}