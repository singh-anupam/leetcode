class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean prime[] = new boolean[1001];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
       
        for(int i=2;i*i<1001;i++)
        {
            if(!prime[i])
            continue;
            for(int j=i*i;j<1001;j+=i)
            {
                prime[j]=false;
            }

        }

        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            continue;
            for(int j=2;j<nums[i];j++)
            {
                if(!prime[j]) continue;
                if(nums[i]-j<nums[i+1])
                {
                    nums[i]-=j;
                    break;

                }
            }
            if(nums[i]>=nums[i+1])
            return false;
        }

        return true;
        
    }
}