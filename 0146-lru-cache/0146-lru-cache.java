/*
    capacity:2
map    3     1
       |     | 
     (3,3) (1,1)
     
    ds: double LinkedList HashMap<Integer, Node<Integer, Integer>>
    get:case1:if 4 is not in the list, return -1
        case2:   in the list   return value remove from original position and moveToHead
               
    put:
    case1:put(1,5), put the exsiting node update the value and move to head
    case2:put(3,3) not exceed capacity, move to head
    case3:put(4,3) the capacity is not enough,remove the last ele, move the new one to head
    update the HashMap
*/
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
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = head;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node res = map.get(key);
        remove(res);
        moveToHead(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() < capacity) {
                moveToHead(newNode);
            } else {
                moveToHead(newNode);
                remove(tail.prev);
            }
        }
        
    }
    
    /*
    node1 node node2
    do not to forget to update the map
    */
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    //head node node1
    //do not to forget to update the map
    private void moveToHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */