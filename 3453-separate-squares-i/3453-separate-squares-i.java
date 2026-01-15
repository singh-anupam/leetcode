class Solution {
    public double separateSquares(int[][] squares) {
        double l = Double.MAX_VALUE;
        double r = -Double.MAX_VALUE;
        double total = 0.0;

        for (int[] arr : squares) {
            total += (double) arr[2] * arr[2];
            l = Math.min(arr[1], l);
            r = Math.max(arr[1] + arr[2], r);
        }

        while (r - l > 1e-5) {
            double mid = l + (r - l) / 2.0;
            if (check(squares, mid, total)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

    private boolean check(int[][] sqr, double target, double total) {
        double bottom = 0.0;

        for (int[] arr : sqr) {
            if (arr[1] < target) {
                if (arr[1] + arr[2] <= target) {
                    bottom += (double) arr[2] * arr[2];
                } else {
                    bottom += (target - arr[1]) * arr[2];
                }
            }
        }
        return bottom >= total / 2.0;
    }
}
