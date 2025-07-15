class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int count =matrix.length*matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j =0;
        int m =matrix.length-1;
        int n =matrix[0].length-1;
        while(count>0){


           for(int x=j;x<=n;x++){
            ans.add(matrix[i][x]);
            count--;
           
           }
           if(count==0)
           break;

           i++;
           for(int x =i;x<=m;x++){
            ans.add(matrix[x][n]);
            count--;
           }
           n--;
           if(count==0)
           break;


           for(int x =n;x>=j;x--){
            ans.add(matrix[m][x]);
            count--;
           }
           m--;
           if(count==0)
           break;

           for(int x =m;x>=i;x--){
            ans.add(matrix[x][j]);
            count--;
           }
           if(count==0)
           break;

           System.out.println(ans);
           j++;



        }

        return ans;
        
    }
}