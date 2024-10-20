class Solution {
    public boolean parseBoolExpr(String expression) {
        
        Stack<Character> stack = new Stack<>();
        for(char ch :  expression.toCharArray())
        {
            if(ch==',')
                continue;
            else if(ch==')')
            {
                List<Character> list = new ArrayList<>();
                while(stack.peek()!='(')
                {
                    list.add(stack.pop());
                }
                
                stack.pop();
                char c = solve(list,stack.pop());
                stack.push(c);
            }
            else
                stack.push(ch);
        }
        
        return stack.peek()=='t'?true:false;
        
    }
    
    private char solve(List<Character> list, char operation)
    {
        if(operation=='!')
            return list.get(0)=='t'?'f':'t';
        else if(operation=='&')
        {
            for(char ch : list)
            {
                if(ch=='f')
                    return 'f';
            }
            return 't';
        }
        else{
            for(char ch :list)
            {
                if(ch=='t')
                    return 't';
            }
            return 'f';
        }
    }
}