// class StockPrice {
//     //we need this two treeMap, imagine the stock picture, one price can respond to multiple timestamp
//     //picture: x is timestamp, y is price
//     //timestamp to price
//     TreeMap<Integer, Integer> record = new TreeMap<>();
//     //price to timestamp
//     TreeMap<Integer, Set<Integer>> val = new TreeMap<>();
//     public StockPrice() {
        
//     }
    
//     public void update(int timestamp, int price) {
//         if (record.containsKey(timestamp)) {
//             //remove the old timestamp from val map
//             int oldPrice = record.get(timestamp);
//             Set<Integer> set = val.get(oldPrice);
//             set.remove(timestamp);
//             if (set.size() == 0) {
//                 val.remove(oldPrice);
//             }
//         }
//         //update
//         record.put(timestamp, price);
//         val.putIfAbsent(price, new HashSet<>());
//         val.get(price).add(timestamp);
//     }
    
//     public int current() {
//         return record.lastEntry().getValue();     
//     }
    
//     public int maximum() {
//         return val.lastKey();
//     }
    
//     public int minimum() {
//         return val.firstKey();
//     }
// }

class StockPrice {
    int latestTime;
    // Store price of each stock at each timestamp.
    Map<Integer, Integer> timestampPriceMap;
    // Store stock prices in increasing order to get min and max price.
    //val is freq
    TreeMap<Integer, Integer> priceFrequency;
    
    public StockPrice() {
        latestTime = 0;
        timestampPriceMap = new HashMap<>();
        priceFrequency = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // Update latestTime to latest timestamp.
        latestTime = Math.max(latestTime, timestamp);
        
        // If same timestamp occurs again, previous price was wrong. 
        if (timestampPriceMap.containsKey(timestamp)) {
            // Remove previous price.
            int oldPrice = timestampPriceMap.get(timestamp);
            priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);
            
            // Remove the entry from the map.
            if (priceFrequency.get(oldPrice) == 0) {
                priceFrequency.remove(oldPrice);
            }
        }
        
        // Add latest price for timestamp.
        timestampPriceMap.put(timestamp, price);
        priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
    }

    public int current() {
        // Return latest price of the stock.
        return timestampPriceMap.get(latestTime);
    }

    public int maximum() {
        // Return the maximum price stored at the end of sorted-map.
        return priceFrequency.lastKey();
    }

    public int minimum() {
        // Return the maximum price stored at the front of sorted-map.
        return priceFrequency.firstKey();
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