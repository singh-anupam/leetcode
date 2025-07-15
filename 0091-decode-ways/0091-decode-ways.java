class Solution {
    public int numDecodings(String s) {

      return  find(s,0);
        
    }

    private int find(String s , int pos){
        if(pos==s.length()){
           
            return 1;
        }
        if(s.charAt(pos)-'0'>=3)
        return find(s,pos+1);
        int cnt1 =0;
        int cnt2 =0;
        if(s.charAt(pos)=='1' || s.charAt(pos)=='2'){
             cnt1 = find(s,pos+1);

            if(pos<s.length()-1){
                if(s.charAt(pos)=='1' ||(s.charAt(pos)=='2') && s.charAt(pos+1)-'0'<=6)
                 cnt2 = find(s,pos+2);

            }
        }
        return cnt1+cnt2;


    }
}