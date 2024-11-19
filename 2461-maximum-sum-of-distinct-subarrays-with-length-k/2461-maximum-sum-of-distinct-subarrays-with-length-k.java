class Solution {
    long ans=0;
    public long maximumSubarraySum(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       Set<Integer> set = new HashSet<>();
       long sum=0;
     
       int r = 0;
       while(r<nums.length){
        int l = (r-k+1<0?r-1:r-k+1);
        while(map.containsKey(nums[r]))
        {
            sum-=nums[l];
            map.remove(nums[l++]);

        }
        map.put(nums[r],r);
        sum+=nums[r];

        if(map.size()==k)
        {
            ans=Math.max(ans,sum);
            map.remove(nums[r-k+1]);
            sum-=nums[r-k+1];
        }
        r++;

       }
       return ans;
        
    }

    // private void find(int arr[], int k, int pos, long sum)
    // {
    //      if(k==0)
    //     {
    //         if(sum>ans)
    //         {
                
    //             ans = sum;
    //             System.out.println(ans);
    //         }
    //         return;
    //     }
    //     if(pos==arr.length)
    //     return ;    
       
        
        
    //         if(pos==0 || arr[pos]!=arr[pos-1])
    //        {
    //         System.out.println(arr[pos]+" "+pos);
    //         find(arr,k-1,pos+1,sum+arr[pos]);

    //        } 
            
        
    //     find(arr,k,pos+1,sum);
    // }

}