class Solution {
    public String lastSubstring(String s) {
        int i =0;
        int j =1;
        int k =0;
        int n = s.length();
        char arr[] = s.toCharArray();
        while(j+k<n){
            if(arr[i+k]==arr[j+k]){
                k++;
            }else if(arr[i+k]>arr[j+k]){
                j=j+k+1;
                k=0;
            }else{
                i = Math.max(i+k+1,j);
                j=i+1;
                k=0;
            }
        }

        return s.substring(i);
        
    }
}