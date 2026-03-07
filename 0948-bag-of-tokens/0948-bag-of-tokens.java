class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i =0;
        int j = tokens.length-1;
        int ans = 0;
        int curScore =0;
        while(i<=j){
            if(tokens[i]<=power){
                power-=tokens[i++];
                curScore++;
                ans = Math.max(ans,curScore);
            }else if(curScore>0){
                power+=tokens[j--];
                curScore--;
            }else
            break;
            
        }

        return ans;
        
    }
}