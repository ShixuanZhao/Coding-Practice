class StockPrice {
    //use sorted data structure
    //key is the timestamp val is the price
    TreeMap<Integer, Integer> record = new TreeMap<>();
    //key is the price, val is a set of timestamp
    TreeMap<Integer, Set<Integer>> val = new TreeMap<>();
    
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> set = val.get(prevPrice);
            set.remove(timestamp);
            if (set.isEmpty()) {
                val.remove(prevPrice);
            }
        }
        val.putIfAbsent(price, new HashSet<>());
        val.get(price).add(timestamp);
        record.put(timestamp, price);
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