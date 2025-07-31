class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i: asteroids)
        {
            if(i<0 && !stack.isEmpty())
            {
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(i))
                {
                     stack.pop();
                }
                if( !stack.isEmpty()&&stack.peek()==Math.abs(i) )
                    stack.pop();
                else if( stack.isEmpty() || stack.peek()<0  )
                    stack.push(i);
            }
          
            else
                stack.push(i);
        }
         int arr[] = new int[stack.size()];
        for(int i=arr.length-1;i>=0;i--)
            arr[i]=stack.pop();
      
        return arr;
    }
}