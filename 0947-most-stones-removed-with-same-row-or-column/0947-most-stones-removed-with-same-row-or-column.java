class Solution {
    class Dsu
    {
        int par[];
        Dsu(int n)
        {
            par = new int[n];
            for(int i=0;i<n;i++)
            {
                par[i]=i;
            }
        }
        
        public int find(int x)
        {
            if(par[x]==x)
                return x;
            return par[x]=find(par[x]);
        }
        
        public boolean union(int a, int b)
        {
            int par_a = find(a);
            int par_b = find(b);
            if(par_a==par_b)
                return true;
            par[par_b]=par[par_a];
            return false;
        }
    }
    public int removeStones(int[][] stones) {
        
        Map<Integer,Integer> rows = new HashMap<>();
        Map<Integer,Integer> cols = new HashMap<>();
        int n =stones.length;
        Dsu dsu = new Dsu(n);
        
        for(int i=0;i<n;i++)
        {
            int r = stones[i][0];
            int c = stones[i][1];
            if(rows.containsKey(r))
            {
                dsu.union(rows.get(r),i);
            }
            rows.put(r,i);
            
            if(cols.containsKey(c))
            {
                dsu.union(cols.get(c),i);
            }
            cols.put(c,i);
            
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            int x = dsu.find(i);
            System.out.println(x);
            map.put(x,map.getOrDefault(x,0)+1);
            
            
        }
        System.out.println("********");
        
        int ans=0;
        for(int k :  map.keySet())
        {
            System.out.println(k+" "+map.get(k));
            ans+=map.get(k)-1;
        }
        return ans;
        
        
        
    }
}