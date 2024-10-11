class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int chairNumber =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> freeSeat = new PriorityQueue<>((a,b)->a-b);
        
        int targetFriendTime = times[targetFriend][0];//since arrival time of every member is unique
        
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        
        for(int i =0;i<times.length;i++)
        {
            int arrTime = times[i][0];
            int deptTime = times[i][1];
            
            while(pq.size()>0 && pq.peek()[0]<=arrTime)
            {
                freeSeat.offer(pq.poll()[1]);
                
            }
            if(freeSeat.size()==0)
            {
                pq.offer(new int[]{deptTime,chairNumber});
                if(targetFriendTime==arrTime)
                    return chairNumber;
                
                chairNumber++;
            }
            else
            {
                int leastChairAvailable = freeSeat.poll();
                if(targetFriendTime ==arrTime)
                    return leastChairAvailable;
                pq.offer(new int[]{deptTime,leastChairAvailable});
            }
        }
        
        return -1;
        
        
        
    }
}