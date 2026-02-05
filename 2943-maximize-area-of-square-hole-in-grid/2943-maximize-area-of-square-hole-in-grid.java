class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxHorCnt = 1,maxVertCnt=1;
        int cnt=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                cnt++;
            }else{
                
                cnt=1;
            }
            maxHorCnt = Math.max(maxHorCnt,cnt);
        }
        cnt=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1)
            cnt++;
            else{
                
                cnt=1; 
            }
            maxVertCnt = Math.max(maxVertCnt,cnt);
        }

        int side  = Math.min(maxVertCnt,maxHorCnt)+1;
        return side*side;
        
    }
}