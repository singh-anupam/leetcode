class Solution {
    class Dsu{
        int par[];
        public Dsu(int n){
            par = new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }

        }
        public boolean union(int u, int v){
            int x = find(u);
            int y = find(v);
            if(x==v){
                return true;
            }
            par[y]=x;
            return true;
        }
        public int find(int x){
            if(par[x]==x)
            return x;
            return par[x] = find(par[x]);
        }
    }
    public int removeStones(int[][] stones) {

        Map<Integer,Integer> rows = new HashMap<>();
        Map<Integer,Integer> cols = new HashMap<>();
        int n = stones.length;
        Dsu dsu =  new Dsu(n);
        for(int i =0;i<stones.length;i++){
            int arr[] = stones[i];
            int r =  arr[0];
            int c = arr[1];
            if(rows.containsKey(r)){
                dsu.union(i,rows.get(r));
            }
            rows.put(r,i);

            if(cols.containsKey(c)){
                dsu.union(i,cols.get(c));
            }
            cols.put(c,i);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = dsu.find(i);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int ans = 0;
        for(int key : map.keySet()){
            ans+=map.get(key)-1;
        }
        return ans;
        
    }
}