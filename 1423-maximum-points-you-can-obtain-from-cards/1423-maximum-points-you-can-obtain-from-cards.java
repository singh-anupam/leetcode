class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=k-1;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int ans =sum;
        // System.out.println(sum);
        int r=cardPoints.length-1;
        for(int i=0;i<k;i++){
            sum-=cardPoints[l--];
            sum+=cardPoints[r-i];
            ans = Math.max(ans,sum);
            // System.out.println(sum);
        }
        return ans;
        
    }
}