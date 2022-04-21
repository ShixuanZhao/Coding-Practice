class TimeMap {
    class Node {
        String key;
        String value;
        int timestamp;
        Node(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    Map<String, List<Node>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       List<Node> cur = map.getOrDefault(key, new ArrayList<Node>());
        cur.add(new Node(key, value, timestamp));
        map.put(key, cur);
    }
    
    //binary search based on timestamp, find the largest ele smaller than target
    public String get(String key, int timestamp) {
        //cur is sorted based on timestamp
        List<Node> cur = map.getOrDefault(key, new ArrayList<Node>());
        if (cur.size() == 0) {
            return "";
        }
        int left = 0;
        int right = cur.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            //get mid, we use arraylist 
            if (cur.get(mid).timestamp == timestamp) {
                return cur.get(mid).value;
            } else if (cur.get(mid).timestamp < timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (cur.get(right).timestamp <= timestamp) {
            return cur.get(right).value;
        } else if (cur.get(left).timestamp <= timestamp) {
            return cur.get(left).value;
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */