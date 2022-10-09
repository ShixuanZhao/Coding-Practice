class ProductOfNumbers {
    /*
    Similar to prefix sum. We can record the prefix product.
Explanation
If we meet 0, the product including this 0 will always be 0.
We only need to record the prefix product after it.
So I clear the A and reinitilise it as [1],
where 1 is the neutral element of multiplication.
    */
    List<Integer> preProd;
    public ProductOfNumbers() {
        preProd = new ArrayList<>();
        preProd.add(1);
    }
    
    public void add(int num) {
        if (num != 0) {
            preProd.add(num * preProd.get(preProd.size() - 1));
        } else {
            //num is 0
            preProd = new ArrayList<>();
            preProd.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = preProd.size();
        return k < n ? preProd.get(n - 1) / preProd.get(n - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */