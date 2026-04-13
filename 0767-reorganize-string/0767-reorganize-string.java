class Solution {
    public String reorganizeString(String s) {

        int freq[] = new int[26];
        int maxFreq = 0;
        char maxLetter = s.charAt(0);
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a']>maxFreq){
                 maxFreq = freq[ch-'a'];
                 maxLetter = ch;
            }
        }

        if(maxFreq>((s.length()+1)/2))
        return "";
        int ptr =0;
        char res[] = new char[s.length()];
        for(int i=0;i<maxFreq;i++){
            res[ptr]=maxLetter;
            ptr+=2;
        }
        freq[maxLetter-'a']=0;

        for(int i=0;i<26;i++){
            if(freq[i]==0)
            continue;
            for(int j=0;j<freq[i];j++){
                if(ptr>=s.length())
                ptr=1;
                res[ptr] = (char)('a'+i);
                ptr+=2;
            }
            freq[i]=0;
        }

        return String.valueOf(res);


        
    }
}