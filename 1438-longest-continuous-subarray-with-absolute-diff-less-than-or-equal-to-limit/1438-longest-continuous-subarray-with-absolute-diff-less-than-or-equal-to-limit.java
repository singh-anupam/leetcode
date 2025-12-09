class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l =0;
        int r =0;
        int ans=0;
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)->b[0]-a[0]);
        while(r<nums.length)
        {
            max.offer(new int[]{nums[r],r});
            min.offer(new int[]{nums[r],r});
            
            while(max.peek()[0]-min.peek()[0]>limit)
            {
                 l = Math.min(min.peek()[1],max.peek()[1])+1;
                while(max.peek()[1]<l)
                    max.poll();
                while(min.peek()[1]<l)
                    min.poll();
            }
           
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
        
    }
}