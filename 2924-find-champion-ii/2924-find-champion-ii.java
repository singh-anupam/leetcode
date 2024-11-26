class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        
        for(int edge[] : edges)
        {
            vis[edge[1]]=true;

        }
        int ans = -1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(ans!=-1)
                return -1;
                ans=i;
            }
        }

        return ans;
        
    }
}