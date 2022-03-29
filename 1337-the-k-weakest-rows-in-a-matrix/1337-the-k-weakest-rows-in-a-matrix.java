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
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
}