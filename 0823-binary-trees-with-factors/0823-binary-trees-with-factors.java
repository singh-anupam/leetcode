class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int mod = 1000000007;
        Map<Integer,Long> map = new HashMap<>();
        map.put(arr[0],1L);
        long sum=1;
        for(int i=1;i<arr.length;i++)
        {
            long x=1;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i]%arr[j]==0)
                {
                    x=(x+(map.get(arr[j])*map.getOrDefault(arr[i]/arr[j],0L)%mod));

                }
            }
            map.put(arr[i],x);
            sum=(sum+x)%mod;
        }
        return (int)sum;

        
    }
}