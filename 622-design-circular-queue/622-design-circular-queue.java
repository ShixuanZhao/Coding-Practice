class MyCircularQueue {
    //pointer
    int head;
    int tail;
    int size;
    //use array to implement queue
    int[] q;
    
    public MyCircularQueue(int k) {
        //[head, tail]
        head = 0;
        tail = -1;
        q = new int[k];
    }
    
    /*
    A   XXAA
    tail   head   A is the ele in the q, this way we can use the space before the head
    */
    public boolean enQueue(int value) {
        if (!isFull()) {
            //move the tail
            //in order of represent the capacity of array, we use q.length instead of k
            //为了使tail重新指向头部，所以%
            tail = (tail + 1) % q.length;
            q[tail] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            head = (head + 1) % q.length;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : q[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : q[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */