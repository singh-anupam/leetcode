class Solution {
    public int minSteps(int n) {
        int x =2;
        int ans =0;
        while(x<=n)
        {
            if(n%x==0)
            {
                ans+=x;
                n=n/x;
            }
            else
                x++;
        }
        if(n!=1)
            ans+=n;
        return ans;
        
    }
}