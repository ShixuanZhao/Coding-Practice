class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //A[0]:the number of one A[1]:the index of row
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            //maxHeap
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0]; 
        });
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            //easy to write but can improve 
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        while (k > 0) {
            res[--k] = pq.poll()[1];
        }
        return res;
    }
    
    private int numOnes(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        /*
        three case:
        00 10 11
        */
        if (row[right] == 1) {
            return right + 1;
        } else if (row[left] == 1){
            return left + 1;
        } else {
            return left;
        }
    }
}