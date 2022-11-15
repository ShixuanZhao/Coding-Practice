class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = head;
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node cur = map.get(key);
            remove(cur);
            moveToHead(cur);
            return cur.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            remove(cur);
            moveToHead(cur);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() < capacity) {
                moveToHead(newNode);
            } else {
                remove(tail.prev);
                moveToHead(newNode);
            }
        }
    }
    
    //head - cur - xx
    private void moveToHead(Node cur) {
        map.put(cur.key, cur);
        cur.next = head.next;
        cur.prev = head;
        head.next.prev = cur;
        head.next = cur;
    }
    
    //xx- cur -xx
    private void remove(Node cur) {
        map.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.next = null;
        cur.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */