class Solution {
    int m;
    int n;
    Random random;
    Set<String> set;

    public Solution(int m, int n) {
        this.m =m;
        this.n = n;
        random = new Random();
        set =new HashSet<>();

        
    }
    
    public int[] flip() {
        int x =random.nextInt(m);
        int y = random.nextInt(n); 
        String str = x+" "+y;
        while(set.contains(str)){
         x =random.nextInt(m);
         y = random.nextInt(n); 
         str = x+" "+y;

        }
        set.add(str);
        return new int[]{x,y};
        
    }
    
    public void reset() {
        set.clear();
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */