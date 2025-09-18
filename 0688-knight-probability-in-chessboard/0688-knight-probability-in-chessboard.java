class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        if(k==0)
        return 1.0;
        double total = find(n,k,row,column);
        // System.out.println(total);

        return (double)(total/(Math.pow(8,k)));
        
    }

    private double find(int n, int k, int row, int column){
        if(k==0){
           if(row<n && row>=0 && column>=0 && column<n)
           return 1;

           return 0;
        }
       if(row>=n || row<0 || column<0 || column>=n)
           return 0;

        double a = find(n,k-1,row-2,column-1);
        double b = find(n,k-1,row-2,column+1);
        double c = find(n,k-1,row-1,column-2);
        double d = find(n,k-1,row+1,column-2);
        double e = find(n,k-1,row-1,column+2);
        double f = find(n,k-1,row+1,column+2);
        double g = find(n,k-1,row+2,column-1);
        double h = find(n,k-1,row+2,column+1);

        return a+b+c+d+e+f+g+h;
    }
}