class WordDictionary {
    class Node{
        Node arr[];
        boolean isLast;
        Node(){
            arr = new Node[26];
            isLast = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
        
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.arr[ch-'a']==null){
                node.arr[ch-'a']=new Node();
            }
            node = node.arr[ch-'a'];
        }
        node.isLast =true;
        
    }
    
    public boolean search(String word) {
       Node node =root;
       return find(word,0,node);
        
        
    }
    private boolean find(String word, int pos, Node node){
        if(pos==word.length())
        return node.isLast;
        if(word.charAt(pos)=='.'){
            
            for(int i=0;i<26;i++){
                if(node.arr[i]==null)
                continue;
               boolean isPos = find(word,pos+1,node.arr[i]);
               if(isPos)
               return true;

            }
            return false;
        }
        if(node.arr[word.charAt(pos)-'a']==null)
        return false;
        return find(word,pos+1,node.arr[word.charAt(pos)-'a']);

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */