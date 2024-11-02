class Solution {
    public boolean isCircularSentence(String sentence) {
        String arr[] = sentence.split(" ");
       if(arr.length==1)
       {
        if(arr[0].charAt(0)!=arr[0].charAt(arr[0].length()-1))
        return false;
       }
        for(int i=0;i<arr.length-1;i++)
        {
            if(i==0)
            {
                String s1 = arr[0];
                String s2 =arr[arr.length-1];
                if(s1.charAt(0)!=s2.charAt(s2.length()-1))
                return false;
            }
            else{
                String s1 = arr[i];
                String s2 =arr[i+1];
                if(s2.charAt(0)!=s1.charAt(s1.length()-1))
                return false;

            }
        }
        return true;
        
    }
}