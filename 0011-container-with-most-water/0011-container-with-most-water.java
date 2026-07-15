class Solution {
    public int maxArea(int[] height) {
        int l =0;
        int r = height.length-1;
        int ans = 0;
        while(l<r){
            int min = Math.min(height[l],height[r]);
            ans = Math.max(ans,min*(r-l));
            if(min == height[r])
            r--;
            else
            l++;

        }
        return ans;
        
    }
}