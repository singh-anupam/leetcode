class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int arr[] = new int[3];
        
        int res[] = new int[]{0,Integer.MAX_VALUE};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++)
        {
            pq.offer(new int[]{nums.get(i).get(0),i,0});
            
            max = Math.max(nums.get(i).get(0),max);
          //  System.out.println(max);
        }
        
        while(true)
        {
            int rm[] = pq.poll();
            if(max - rm[0]<res[1]-res[0])
            {
                res[0]=rm[0];
                res[1]=max;
            }
//             System.out.println(res[1]-res[0]);
            
//             System.out.println(rm[0]+" "+max);
           
            int r = rm[1];
            int c = rm[2];
            if(c==nums.get(r).size()-1)
                break;
            c++;
            pq.offer(new int[]{nums.get(r).get(c),r,c});
             max = Math.max(max,nums.get(r).get(c));
        }
        
        return res;
        
        
        
        
    }
}