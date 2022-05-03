class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    ListNode dummy;
    int size;
    public MyLinkedList() {
        dummy = new ListNode(0);
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = dummy;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    //if we use DDL, we can cost O(1)
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    //insert before the index-th node
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //now, cur pointer to the prev node
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        //cur.next.next = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */