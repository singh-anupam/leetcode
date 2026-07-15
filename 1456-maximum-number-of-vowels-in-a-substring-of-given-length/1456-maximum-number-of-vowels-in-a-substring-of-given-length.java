class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            count++;
        }
        int l = 0;
        int r = k;
        int ans = count;
        while(r<s.length()){
            if(s.charAt(r)=='a' || s.charAt(r)=='e' || s.charAt(r)=='i' || s.charAt(r)=='o' || s.charAt(r)=='u')
            count++;
            if(s.charAt(l)=='a' || s.charAt(l)=='e' || s.charAt(l)=='i' || s.charAt(l)=='o' || s.charAt(l)=='u')
            count--;

            ans = Math.max(ans,count);

            r++;
            l++;
        }

        return ans;
        
    }
}