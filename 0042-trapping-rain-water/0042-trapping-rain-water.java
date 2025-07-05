class Solution {
    public int trap(int[] height) {
         if (height.length == 0 || height.length == 1 || height.length == 2) {
        return 0;
    }
    int res = 0;
    int[] lMax = new int[height.length];
    int[] rMax = new int[height.length];
    lMax[0] = height[0];
    rMax[height.length - 1] = height[height.length - 1];
        System.out.println("lmax: ");
    for (int i = 1; i < height.length; i++) {
        lMax[i] = Math.max(lMax[i - 1], height[i]);
        System.out.print(" "+lMax[i]);
    }
        
        System.out.println("rmax: ");
    for (int i = height.length - 2; i >= 0; i--) {
        rMax[i] = Math.max(rMax[i + 1], height[i]);
        System.out.print(" " +rMax[i]);
    }
    for (int i = 1; i < height.length - 1; i++) {
        res += Math.min(lMax[i], rMax[i]) - height[i];
    }
    return res;
        
    }
}