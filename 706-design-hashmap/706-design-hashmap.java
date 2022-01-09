class MyHashMap {
//     Some of the questions which can be asked to the interviewer before implementing the solution
// For simplicity, are the keys integers only?
// For collision resolution, can we use chaining?
// Do we have to worry about load factors?
// Can we assume inputs are valid or do we have to validate them?
// Can we assume this fits memory?
	// 原理是需要用array来实现random access，保证平均情况下hashmap的put和get是O（1）的，如果出现了collision，
	// 那么可以选择使用linkedlist来处理collision的情况，所以在put get 和remove的时候，
	// 需要一个while loop来查找所有collision的元素，导致worst case是O（n）因此我在这里把listnode改变了一下结构，
	// 使其能够同时存储key和value，便于查找，同时需要保证key是final无法被改变。
	// 而根据题意这个size最大是10000所以array的size是10001来保证array[10000]可以被取值。
    class Node {
            final int key;
            int val;
            Node next;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    
    final int SIZE = 10001;
    Node[] arr;
    public MyHashMap() {
        arr = new Node[SIZE];
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = arr[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        Node newHead = new Node(key, value);
        newHead.next = head;
        arr[index] = newHead;
    }
    
    public int get(int key) {
        int index = getIndex(key);
        Node head = arr[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node head = arr[index];
        Node node = head;
        Node dummy = new Node(-1, -1);
        dummy.next = head;
        Node prev = dummy;
        arr[index] = dummy;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */