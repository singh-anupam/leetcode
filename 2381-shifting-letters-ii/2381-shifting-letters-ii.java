class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int arr[] = new int[s.length()+1];
        for(int a[] : shifts){
            int u  = a[0];
            int v = a[1]+1;
            int val = a[2]==0?-1:1;
            arr[u]+=val;
            arr[v]-=val;
        }
        StringBuilder sb = new StringBuilder();
        int sum =0;
        for(int i=0;i<s.length();i++){
             sum+= arr[i];
             int val=sum;
            if(val>=0)
            val=((s.charAt(i)-'a')+val)%26;
            else
             val = ((s.charAt(i) - 'a' + val) % 26 + 26) % 26;

            sb.append((char)(val+97));

        }

        return sb.toString();
        
    }
}