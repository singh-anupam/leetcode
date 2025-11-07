class Solution {
    public boolean isValidSerialization(String preorder) {

        Stack<Character> stack = new Stack<>();

        for(char ch : preorder.toCharArray()){
            if(ch==',')
            continue;
            if(ch=='#'){
            while(stack.size()>0 && stack.peek()=='#'){
                stack.pop();
                if(stack.size()==0)
                return false;
                stack.pop();

            }
            }
            
            stack.push(ch);
        }

        return stack.size()==1 && stack.peek()=='#';
        
    }
}