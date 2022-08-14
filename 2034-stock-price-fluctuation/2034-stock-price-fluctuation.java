class StockPrice {
    //we need this two treeMap, imagine the stock picture, one price can respond to multiple timestamp
    //picture: x is timestamp, y is price
    //timestamp to price
    TreeMap<Integer, Integer> record = new TreeMap<>();
    //price to timestamp
    TreeMap<Integer, Set<Integer>> val = new TreeMap<>();
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            //remove the old timestamp from val map
            int oldPrice = record.get(timestamp);
            Set<Integer> set = val.get(oldPrice);
            set.remove(timestamp);
            if (set.size() == 0) {
                val.remove(oldPrice);
            }
        }
        //update
        record.put(timestamp, price);
        val.putIfAbsent(price, new HashSet<>());
        val.get(price).add(timestamp);
    }
    
    public int current() {
        return record.lastEntry().getValue();     
    }
    
    public int maximum() {
        return val.lastKey();
    }
    
    public int minimum() {
        return val.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */