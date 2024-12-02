class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count =1;
        for(String str: sentence.split(" "))
        {
            if(str.contains(searchWord) && str.indexOf(searchWord)==0)
                return count;
            count++;
        }
        return -1;
        
        
    }
}