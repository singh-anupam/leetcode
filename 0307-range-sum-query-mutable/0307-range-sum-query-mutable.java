class NumArray {

    SegmentTree tree;

    public NumArray(int[] nums) {

        tree = new SegmentTree(nums);

        
    }
    
    public void update(int index, int val) {
        tree.update(index,val);
        
    }
    
    public int sumRange(int left, int right) {
      return  tree.querry(left,right);
    }
    class SegmentTree{
        int n;
        int arr[];

        public SegmentTree(int nums[]){
            this.n = nums.length;
            this.arr = new int[4*n];
            construct(nums,0, 0,n-1);

        }

        private void construct(int nums[], int idx, int l, int r){
            if(l==r){
                arr[idx]=nums[l];
                return ;
            }
            int mid = l+(r-l)/2;
             construct(nums,2*idx+1,l,mid);
             construct(nums,2*idx+2,mid+1,r);
            arr[idx] = arr[2*idx+1]+arr[2*idx+2];
           
        }

        public int querry(int l, int r){
            return querry(0,0,n-1,l,r);
        }

        private int querry(int idx, int low, int high, int left, int right){
            if(low>right || high<left)
            return 0;

            if(left<=low && right>=high)
            return arr[idx];

            int mid = low+(high-low)/2;
            int leftVal = querry(2*idx+1,low,mid,left,right);
            int rightVal = querry(2*idx+2,mid+1,high,left,right);

            return leftVal+rightVal;
        }

        public void update(int idx, int val){
            update(0,0,n-1,idx,val);
        }

        private void update(int idx, int low, int high, int pos, int val){
            if(low==high){
            arr[idx]=val;
            return;
            }

            int mid = low+(high-low)/2;

            if(pos<=mid)
            update(2*idx+1,low,mid,pos,val);
            else
            update(2*idx+2,mid+1,high,pos,val);

            arr[idx] = arr[idx*2+1]+arr[idx*2+2];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */