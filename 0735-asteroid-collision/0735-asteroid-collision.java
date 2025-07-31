class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty() || asteroids[i]>0)
            stack.push(asteroids[i]);
            else
            {
                if(stack.peek()<0)
                stack.push(asteroids[i]);
                else{
                    while(stack.size()>0 && stack.peek()<Math.abs(asteroids[i]))
                    stack.pop();
                    if(stack.size()==0)
                    stack.push(asteroids[i]);

                    else if(stack.peek()==Math.abs(asteroids[i]))
                    {
                        stack.pop();
                        continue;
                    }
                    
                }
            }

        }
        int x =stack.size()-1;
        int ans[] = new int[stack.size()];
        while(stack.size()>0){
            ans[x--]=stack.pop();
        }
        return ans;
        
    }
}