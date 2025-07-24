class Solution {
    class Pair{
        double val;
        String nbr;
        Pair(String nbr, double val){
            this.nbr = nbr;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair>> map = new HashMap<>();
        int x =0;
        for(List<String> eqn : equations){
            String u = eqn.get(0);
            String v = eqn.get(1);
            List<Pair> list  = map.getOrDefault(u,new ArrayList<>());
            list.add(new Pair(v,values[x]));
            map.put(u,list);
            List<Pair> list2 = map.getOrDefault(v,new ArrayList<>());
            list2.add(new Pair(u,1/values[x++]));
            map.put(v,list2);
        }
        double ans[] = new double[queries.size()];
        int i=0;

        for(List<String> querry : queries){
            String u = querry.get(0);
            String v = querry.get(1);
             ans[i++] = dfs(map,u,v, new HashSet<>(),1.0);
            
        }
        return ans;
        
    }

    private double dfs(Map<String,List<Pair>> map, String src, String dst, Set<String> vis,double cur){
       if(!map.containsKey(src) || !map.containsKey(dst))
        return -1;
        if(dst.equals(src))
        return cur;
        vis.add(src);
        
        for(Pair p :  map.get(src)){
            if(!vis.contains(p.nbr)){
                // System.out.println(p.nbr);
            double d = dfs(map,p.nbr,dst,vis,cur*p.val);
            if(d!=-1.0)
            return d;
            }
        }
        vis.remove(src);
        return -1.0;


    }
}