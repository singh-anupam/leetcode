class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
           int rmin = 0;
        int cmin = 0;
        int rmax = matrix.length-1;
        int cmax = matrix[0].length-1;
        int counter=0;
        int tne = matrix.length*matrix[0].length;
//         while(counter<tne){
//             //left boundary
//             for(int row=rmin;row<=rmax&&counter<tne;row++){
//                 System.out.println(arr[row][cmin]);
//                 counter++;
//             }
//             cmin++;
//             //bottom boundary
//             for(int col=cmin;col<=cmax&&counter<tne;col++){
//                 System.out.println(arr[rmax][col]);
//                 counter++;
//             }
//             rmax--;
//             //right boundary
//             for(int row=rmax;row>=rmin&&counter<tne;row--){
//                 System.out.println(arr[row][cmax]);
//                 counter++;
//             }
//             cmax--;
//             //top boundary
//             for(int col=cmax;col>=cmin&&counter<tne;col--){
//                 System.out.println(arr[rmin][col]);
//                 counter++;

//             }
//             rmin++;
//         } 
        
        while(counter<tne)
        {
            for(int c=cmin;c<=cmax && counter<tne;c++)
            {
                list.add(matrix[rmin][c]);
                counter++;
            }rmin++;
            for(int r = rmin;r<=rmax && counter<tne;r++)
            {
                list.add(matrix[r][cmax]);
                counter++;
            }
            cmax--;
            for(int c=cmax;c>=cmin && counter<tne;c--)
            {
                list.add(matrix[rmax][c]);
                counter++;
            }
            rmax--;
            for(int r=rmax;r>=rmin && counter<tne;r--)
            {
                list.add(matrix[r][cmin]);
                counter++;
            }cmin++;
        }
        return list;
    }
}