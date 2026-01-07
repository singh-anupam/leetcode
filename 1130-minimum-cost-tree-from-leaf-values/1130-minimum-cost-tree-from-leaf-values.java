class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int maxArr[][] = new int[arr.length][arr.length];
        int dp[][] = new int[arr.length][arr.length];
        
        for(int brr[] :  dp)
            Arrays.fill(brr,-1);
        
        for(int i =0;i<arr.length;i++)
        {
            int max = arr[i];
            for(int j=i;j<arr.length;j++)
            {
                max= Math.max(max,arr[j]);
                maxArr[i][j]=max;
            
               // System.out.println(max);
            }
            
        }
        
        
        
        
        return find(arr,0,arr.length-1,maxArr, dp);
        
    }
    private int find(int arr[], int left, int right, int maxArr[][], int brr[][])
    {
        if(left==right)
            return 0;
        if(brr[left][right]!=-1)
            return brr[left][right];
        int min = Integer.MAX_VALUE;
        for(int k=left;k<right;k++)
        {
            min = Math.min(min,(maxArr[left][k]*maxArr[k+1][right])+find(arr,left,k,maxArr,brr) + find(arr,k+1,right,maxArr,brr));
        }
        return brr[left][right] = min;
    }
}