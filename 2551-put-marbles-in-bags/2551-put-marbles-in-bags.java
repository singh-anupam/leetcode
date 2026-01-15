class Solution {
    public long putMarbles(int[] weights, int k) {
        long pairSum[] = new long[weights.length-1];

        int prev = weights[0];
        for(int i=1;i<weights.length;i++){
            pairSum[i-1] = (long)prev +weights[i];
            prev = weights[i];
        }

        Arrays.sort(pairSum);
        long minSum = 0;
        long maxSum = 0;
        for(int i=0;i<k-1;i++){
            minSum+=pairSum[i];
            maxSum+=pairSum[pairSum.length-1-i];
        }

        return maxSum-minSum;
        
    }
}