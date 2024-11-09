class Solution {
    public long minEnd(int n, int x) {
        long ans=x;
        for(int i=1;i<n;i++){
            long next = ans+1;
            if((ans&next)==x)
            ans=next;
            else
            ans=next|x;

        }
        return ans;
        
    }
}