public class ZigzagIterator {
    //using q
    Queue<Iterator> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if (!v1.isEmpty()) {
            q.offer(v1.iterator());
        }
        if (!v2.isEmpty()) {
            q.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator cur = q.poll();
        int res = (int)cur.next();
        if (cur.hasNext()) {
            q.offer(cur);
        }
        return res;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */