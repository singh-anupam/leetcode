class Solution {
    public double soupServings(int n) {
        double arr[][]=new double[4801][4801];
        
        if(n>4800)
            return 1;
        return find(n,n,arr);
        
    }
    
    public double find(int a, int b,double arr[][])
    {
        if(a<=0 && b<=0)
        {
            return 0.5;
      }
        if(a<=0)
        {
            return 1;
        }
        if(b<=0)
        {
            return 0;
        }
        if(arr[a][b]!=0)
            return arr[a][b];
        double p = find(a-100,b,arr);//1
        double q = find(a-75,b-25,arr);//1
        double r = find(a-50,b-50,arr);//0.5
        double s = find(a-25,b-75,arr);
         return arr[a][b]=0.25*(p+q+r+s);
        
      
    }
}