class Solution {
    int arr[];
    Random random;

    public Solution(int[] nums) {
        arr = nums;
        random = new Random();
        
    }
    
    public int[] reset() {
        return arr;
        
    }
    
    public int[] shuffle() {
        int temp[] = arr.clone();
        for(int i=arr.length-1;i>0;i--){
            int t = random.nextInt(i+1);
            int ele = temp[t];
            temp[t] = temp[i];
            temp[i]=ele;

        }

        return temp;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */