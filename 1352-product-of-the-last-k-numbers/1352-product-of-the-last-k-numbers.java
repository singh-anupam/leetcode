class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        
    }
    
    public void add(int num) {
        if(num==0)
        {
            list.clear();
            list.add(1);
            return ;
        }

        list.add(num*list.get(list.size()-1));
        
    }
    
    public int getProduct(int k) {
        if(list.size()>k)
        return list.get(list.size()-1)/list.get(list.size()-k-1);

        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */