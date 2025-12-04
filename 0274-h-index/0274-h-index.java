class Solution {
    public int hIndex(int[] citations) {
        int arr[] = new int[citations.length+1];
        for(int i : citations)
        {
            if(i>=citations.length)
            arr[citations.length]++;
            else
            arr[i]++;
        }
        int sum=0;
        for(int i=citations.length;i>=0;i--)
        {
            sum+=arr[i];
           if( i<=sum)
            return i;
        }
        return 0;
        
    }
}