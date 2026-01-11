class Solution {
    public int maximalRectangle(char[][] matrix) {

        int max = 0;
        int arr[] = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            
            for(int j =0;j<matrix[0].length;j++){
                arr[j]=matrix[i][j]-'0'==0?0:arr[j]+1;
                // System.out.print(arr[j]+" ");
            }
            // System.out.println();
            max = Math.max(max,getArea(arr));
        }
        // System.out.println("###");
        // getArea(new int[]{2,4,3,1,1,1,0,5});

        return max;
        
        
    }

    private int getArea(int arr[]){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int area =0;
        for(int i =0;i<=n;i++){
            int h = i==n?0:arr[i];
            while(stack.size()>0 && arr[stack.peek()]>h){
                int x = arr[stack.pop()];
                int w = stack.size()==0?i:i-stack.peek()-1;
                // System.out.println(x+" "+w);
                area = Math.max(area,w*x);

            }
            stack.push(i);
        }

        return area;
    }
}