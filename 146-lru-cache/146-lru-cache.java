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
   //define double LinkedList
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
    
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = head;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
       //case1
        if (!map.containsKey(key)) {
            return -1;
        } else {
            //case2
            Node cur = map.get(key);
            int res = cur.val;
            remove(cur);
            moveToHead(cur);
            return res;
        }
    }
    
    public void put(int key, int value) {
        //case1
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            remove(cur);
            moveToHead(cur);
        } else {
            //case2:not exceed capacity
            Node cur = new Node(key, value);
            if (map.size() < capacity) {
                moveToHead(cur);
            } else {
                //case3
                //remove the last element
                remove(tail.prev);
                moveToHead(cur);
            }
        }
    }
    
    //add the ele to the head
    private void moveToHead(Node cur) {
        map.put(cur.key, cur);
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    
    //delete the certain ele
    private void remove(Node cur) {
        map.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */