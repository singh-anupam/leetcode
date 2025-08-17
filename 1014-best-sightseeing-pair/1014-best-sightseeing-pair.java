class Solution {
    public int maxScoreSightseeingPair(int[] values) {
       // int dp[] = new int[values.length];
        int ans=0;
        int max = values[0]-1;
        
        for(int i=1;i<values.length;i++)
        {
            
            ans = Math.max(values[i]+max,ans);
            max=Math.max(max,values[i])-1;
         
        }
        return ans;
    }
}