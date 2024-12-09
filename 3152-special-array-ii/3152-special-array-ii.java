// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         boolean ans[] = new boolean[queries.length];
//         int arr[] = new int[nums.length];
//         for(int i=1;i<nums.length;i++)
//         {
//             if(nums[i]%2==0)
//             {
//                 if(nums[i-1]%2==0)
//                 {
//                     arr[i]=arr[i-1]+1;
//                 }
//                 else
//                 {
//                     arr[i]=arr[i-1];
//                 }
//             }
//             else{
//                 if(nums[i-1]%2==0)
//                 {
//                     arr[i]=arr[i-1];
//                 }
//                 else
//                 {
//                     arr[i]=arr[i-1]+1;
//                 }

//             }
//         }

//         for(int i=0;i<queries.length;i++){
//             ans[i]=arr[queries[i][0]]==arr[queries[i][1]];
//         }

//         return ans;
        
//     }
// }

class Solution {
    private boolean find(List<Integer> vi, int sp, int ep) {
        int l = 0;
        int r = vi.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (vi.get(mid) < sp) {
                l = mid + 1;
            } else if (vi.get(mid) > ep) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        List<Integer> vi = new ArrayList<>(); // List of violating indices

        for (int i = 1; i < n; i++) { 
            if (nums[i] % 2 == nums[i - 1] % 2) {
                vi.add(i);
            }
        }

        boolean[] result = new boolean[m];

        for (int i = 0; i < m; i++) { 
            int start = queries[i][0];
            int end = queries[i][1];

            boolean hasViolatingIndexInRange = find(vi, start + 1, end);

            if (!hasViolatingIndexInRange) { 
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}