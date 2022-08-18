class StockSpanner {
    //maintain a descreasing stack
    /*
    initial res to 1
    [100,80,60,70,60,75,85]
                  i
      stack:100 80 60
      res:1 1 1 2 2
     stack:100 85 
     1 1 1 2 1 4(1 + 1 + 2) 1 + 4 + 1 = 6
                     60  70
                     
     so we also need to store the previous res in the stack
    */
    Deque<int[]> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        //pair <price, res>
        int res = 1;
        //less than or equal to today's price.
        while (!stack.isEmpty() && price >= stack.peekFirst()[0]) {
            res += stack.pollFirst()[1];
        }
        stack.offerFirst(new int[] {price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */