class Solution {
    /*
        input:int[][] points, int k
        output: int[][]
        clarify: k >= points.length return all the points
                  else   return k cloest
        k > 0, number of points > 0
        high level:use a maxHeap size == k, compare by the distance
        iterate the points
        if (size of heap < k)
            push the point into heap
       else 
            if(top of maxHeap > new point) {
                pop the top and push the new one
            } else {
                do nothing
            }
    */
    class Pair {
        int dis;
        int index;
        public Pair(int dis, int index) {
            this.dis = dis;
            this.index = index;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        //define a maxHeap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> (b.dis - a.dis));
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (maxHeap.size() < k) {
                maxHeap.offer(new Pair(distance, i));
            } else {
                if (maxHeap.peek().dis > distance) {
                    maxHeap.poll();
                    maxHeap.offer(new Pair(distance, i));
                }
            }
        }
        //output
        int[][] res = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            //pay attention to the type
            res[i] = points[maxHeap.poll().index];
        }
        return res;
    }
}