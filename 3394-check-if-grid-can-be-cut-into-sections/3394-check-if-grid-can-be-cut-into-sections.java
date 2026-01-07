class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles,(a,b)->a[0]==b[0]?a[2]-b[2]:a[0]-b[0]);

        // printArr(rectangles);

        boolean x = check(rectangles,true);
        
        if(x)
        return true;

        Arrays.sort(rectangles,(a,b)->a[1]==b[1]?a[3]-b[3]:a[1]-b[1]);
        //   printArr(rectangles);
        return check(rectangles,false);
        
    }

    private void printArr(int arr[][]){
        System.out.println("###");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+","+arr[i][1]);
        }
    }

    private boolean check(int arr[][],boolean isX){
        // System.out.println("##");
        int end = isX?arr[0][2]:arr[0][3];
        int count =0;
        for(int i=1;i<=arr.length-1;i++){
            System.out.println(end);
            if(end<=(isX?arr[i][0]:arr[i][1])){
                count++;
               
            }
            if(count==2)
            return true;
             end = Math.max(end,isX?arr[i][2]:arr[i][3]);
        }
        return false;
    }
}