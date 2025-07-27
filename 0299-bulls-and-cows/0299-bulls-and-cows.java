class Solution {
    public String getHint(String secret, String guess) {
        String str = "";
        int i=0,j=0;
        int bulls=0,cows=0;
        int arr[] = new int[10];
        while(i<secret.length() && j<guess.length()){
            if(secret.charAt(i)==guess.charAt(j))
            bulls++;
            else 
            arr[secret.charAt(i)-'0']++;
            i++;
            j++;
        }
        i=0;
        while(i<guess.length()){
            if(arr[guess.charAt(i)-'0']>0)
            {
                arr[guess.charAt(i)-'0']--;
                cows++;
            }
            i++;

        }
        return bulls+"A"+cows+"B";
        
    }
}