class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        
        Set<String> set = new HashSet<>();
        solve(s,0,set);
        return max; 
        
    }
    
    private void solve(String s, int idx, Set<String> set)
    {
        if(idx==s.length())
        {
            max = Math.max(max,set.size());
            
            return;
        }
      //  System.out.println(set + " "+set.size());
        
        for(int i=idx+1;i<=s.length();i++)
        {
            String str =substring(s,idx,i);
        //    System.out.println(str);
            if(!set.contains(str))
            {
                
                set.add(str);
                solve(s,i,set);
                set.remove(str);
            }
        }
    }
    
    private String substring(String str, int idx, int i)
    {
        String s = "";
        for(int j=idx;j<i;j++)
        {
            s+=str.charAt(j);
        }
        return s;
    }
}