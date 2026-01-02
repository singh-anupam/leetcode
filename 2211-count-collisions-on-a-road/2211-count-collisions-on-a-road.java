class Solution {
    public int countCollisions(String directions) {
        int ans =0;
        int r =0;
        int s=0;
        for(char ch :directions.toCharArray()){
            if(ch=='R'){
                r++;
                s=0;
            }else if(ch=='S'){
                ans+=r;
                r=0;
                s=1;
            }else
            {
                if(r>0){
                    ans+=r+1;
                    r=0;
                    s=1;
                }else if(s>0) ans++;
            }
        }

        return ans;
        
    }
}