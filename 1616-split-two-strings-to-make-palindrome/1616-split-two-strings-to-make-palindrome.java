class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b) || check(b,a);
    }

    private boolean check(String a, String b){
        int l = 0;
        int r = b.length()-1;
        while(l<=r){
            if(a.charAt(l)!=b.charAt(r))
            return find(a,l,r) || find(b,l,r);
            l++;r--;
        }
        return true;
    }

    private boolean find(String a, int l, int r){
        while(l<r){
            if(a.charAt(l++)!=a.charAt(r--))
            return false;
        }
        return true;
    }
}