class Solution {
    /*
    
    Thus, the max heap is always maintain top K smallest elements from the first one to crruent one. Once the size of the heap is over its maximum capacity, 
	it will exclude the maximum element in it, since it can not be the proper candidate anymore.
	
    use a maxHeap size == k, store Point
    iterate the points arr,
    if size < k, push into q
    else   
        if dis to (0,0) < top in maxHeap, pop the top and push into heap
    */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> ((b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y)));
        for (int[] p : points) {
            if (pq.size() < k) {
                pq.offer(new Point(p[0], p[1]));
            } else if (pq.peek().x * pq.peek().x + pq.peek().y * pq.peek().y > p[0] * p[0] + p[1] * p[1]) {
                pq.poll();
                pq.offer(new Point(p[0], p[1]));
            }
        }
        int[][] res = new int[k][2];
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            res[--k] = new int[] {p.x, p.y};
        }
        return res;
    }
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}