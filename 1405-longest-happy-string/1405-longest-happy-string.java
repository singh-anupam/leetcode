class Solution {
    class Pair
    {
        char ch;
        int count;
        Pair(char ch , int count)
        {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String longestDiverseString(int a, int b, int c) {
        
        String ans ="";
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.count-x.count);
        
        if ( a!= 0)
        pq.add(new Pair( 'a',a));
         if ( b!= 0)
        pq.add(new Pair( 'b',b));
        
        if (c != 0)
        pq.add(new Pair('c',c));
        
        
        while(pq.size()>0)
        {
            Pair rm = pq.poll();
            
            if(ans.length()<2 || (ans.charAt(ans.length()-1)!=rm.ch || ans.charAt(ans.length()-2)!=rm.ch))
            {
                ans+=rm.ch;
                if(rm.count-1>0)
                {
                    rm.count=rm.count-1;
                    pq.offer(rm);
                }
                
            }
            
            else{
                if(pq.size()>0){
                    Pair rm2 = pq.poll();
                    ans+=rm2.ch;
                    if(rm2.count-1>0)
                    {
                        rm2.count = rm2.count-1;
                        pq.offer(rm2);
                    }
                    
                    pq.offer(rm);
                }
                else
                    break;
            }
            
        }
        
        
        
        
        
        return ans;
        
        
    }
}