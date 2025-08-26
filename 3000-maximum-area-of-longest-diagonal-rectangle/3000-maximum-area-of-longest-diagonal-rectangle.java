class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        double max = 0;
        int area= 0;
        for(int arr[] : dimensions){
            double d = Math.sqrt(arr[0]*arr[0]+arr[1]*arr[1]);
           
            if(d>=max)
            {
                //  System.out.println(d);
                max=d;
                area = Math.max(arr[0]*arr[1],area);
            }

        }

        return area;
        
    }
}