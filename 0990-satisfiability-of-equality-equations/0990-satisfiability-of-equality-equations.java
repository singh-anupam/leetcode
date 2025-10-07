class Solution {
    class Dsu{
        int par[];
        Dsu(int n){
            par = new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }
        }

        public boolean union(int u, int v){
            int x = find(u);
            int y = find(v);
            if(x==y)
            return true;

            par[y]=par[x];
            return false;
        }

        public int find(int x){
            if(par[x]==x)
            return x;
            return par[x]=find(par[x]);
        }
    }
    public boolean equationsPossible(String[] equations) {

        Dsu dsu = new Dsu(26);
        for(String eqn : equations){
            if(eqn.charAt(1)=='!')
            continue;
            int ch1 = eqn.charAt(0)-'a';
            int ch2 = eqn.charAt(3)-'a';
            dsu.union(ch1,ch2);
        }

        for(String eqn : equations){
            if(eqn.charAt(1)=='=')
            continue;
            int ch1 = eqn.charAt(0)-'a';
            int ch2 = eqn.charAt(3)-'a';
            if(ch2==dsu.find(ch1) || ch1==dsu.find(ch2))
            return false;
        }

        return true;
        
    }
}