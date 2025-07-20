class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length())
        return false;

        return find(s1,s2,s3,0,0,0);
        
    }
    private boolean find(String s1, String s2, String s3, int i , int j, int k){
        if(i==s1.length() && j==s2.length() && k==s3.length())
        return true;
        if(i==s1.length()){
            if(s2.charAt(j)==s3.charAt(k))
            return find(s1,s2,s3,i,j+1,k+1);
            return false;
        }
        if(j==s2.length()){
            if(s1.charAt(i)==s3.charAt(k))
            return find(s1,s2,s3,i+1,j,k+1);
            return false;
        }
        boolean a =false;
        boolean b =false;
        if(s1.charAt(i)==s3.charAt(k))
      a =find(s1,s2,s3,i+1,j,k+1);
      if(s2.charAt(j)==s3.charAt(k))
      b =find(s1,s2,s3,i,j+1,k+1);

      return a||b;
    }
}