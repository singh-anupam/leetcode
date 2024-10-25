class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int arr[] = new int[1001];
        for(int num : nums1)
        {
            arr[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2)
        {
            if(arr[num]>0)
            {
                list.add(num);
                arr[num]--;
            }

        }
        int ans[]  = new int[list.size()];
        for(int i=0;i<ans.length;i++)
        ans[i]=list.get(i);

        return ans;
        
    }
}