class Solution {
    class Node{
        Node child[];
        List<String> values;
        Node(){
            child = new Node[26];
            values = new ArrayList<>();
        }
    }
    Node root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root=new Node();
        for(String product : products){
            addWord(product);
        }

        return search(searchWord);
        
    }

    private boolean addWord(String word){
        Node node =root;
        for(char ch : word.toCharArray()){
            if(node.child[ch-'a']==null){
                node.child[ch-'a']=new Node();
            }
            node = node.child[ch-'a'];
            node.values.add(word);
        }
        return true;
    }

    private List<List<String>> search(String word){
        Node node = root;
        List<List<String>> ans = new ArrayList<>();
        for(char ch :  word.toCharArray()){
            if(node.child[ch-'a']==null){
                ans.add(new ArrayList<>());
                continue;
            }
            node = node.child[ch-'a'];
           
            List<String> list = node.values;
            Collections.sort(list);
            int x =0;
            List<String> l = new ArrayList<>();
            for(String str :  list){
                l.add(str);
                x++;
                if(x==3)
                break;

            }
            ans.add(l);

        }

        return ans;

    }
}