class Solution {
    public List<Integer> grayCode(int n) {

        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            str.append('0');
        }

        boolean vis[] = new boolean[1<<n];
        List<Integer> ans = new ArrayList<>();
        vis[0]=true;
        ans.add(0);

        dfs(str,ans,vis);

        return ans;

        
    }

    private void dfs(StringBuilder str, List<Integer> ans, boolean vis[])
    {
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            str.setCharAt(i,ch=='0'?'1':'0');
            int val = Integer.parseInt(str.toString(),2);
            if(!vis[val]){
                vis[val]=true;
                ans.add(val);
                dfs(str,ans,vis);
            }
             str.setCharAt(i,ch);

        }
    }
}