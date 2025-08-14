class Solution {
    class Pair
    {
        String s;
        int count ;
        Pair(String s, int count)
        {
            this.s = s;
            this.count = count;
        }
        
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String,Integer> map = new HashMap<>();
        
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[friends.length];
        q.offer(id);
        vis[id]=true;
        int count =0;
        while(q.size()>0)
        {
            if(count==level)
                break;
       int size =q.size();
            for(int i=0;i<size;i++)
            {
            int rm = q.poll();
            
           
            for(int nbr : friends[rm])
            {
                
                if(!vis[nbr])
                {
                    vis[nbr]=true;
                    q.offer(nbr);
                }
                
                
            }
            }
            count++;
            
        }
        
        
        
        while(q.size()>0)
        {
            int rm =q.poll();
           // System.out.println(rm+"*******");
            for(String s : watchedVideos.get(rm))
            {
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        List<String> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.count==b.count?a.s.compareTo(b.s):a.count-b.count);
        
        
        
        for(String s : map.keySet())
        {
            //System.out.println(s+" "+map.get(s));
            pq.offer(new Pair(s,map.get(s)));
        }
        while(pq.size()>0)
        {
            ans.add(pq.poll().s);
        }
        
        return ans;
    }
}