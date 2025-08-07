class Solution {
    public List<Long> maximumEvenSplit(long n) {
        if (n % 2 != 0)
            return new ArrayList<>();

        long x = 2;
        List<Long> ans = new ArrayList<>();
        while (x <= n) {
            ans.add(x);
            n -= x;
            x += 2;
        }

        long last = ans.remove(ans.size()-1);
        ans.add(last+n);

        return ans;

    }
}