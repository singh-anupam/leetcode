class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int ans[] = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
            pq.offer(new int[]{i,map.get(i)});
            while(pq.size()>k){
                pq.poll();
            }

        }
        int x =0;

        while(pq.size()>0){
            ans[x++]=pq.poll()[0];
        }
        return ans;

        
    }
}