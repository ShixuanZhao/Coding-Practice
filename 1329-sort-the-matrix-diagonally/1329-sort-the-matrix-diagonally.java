class Solution {
//     A[i][j] on the same diagonal have same value of i - j
// For each diagonal,
// put its elements together, sort, and set them back.
// Time O(MNlogD), where D is the length of diagonal with D = min(M,N).
// Space O(MN)
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //for (i, j)
        //key is the unique (i - j), each diagonal has unique i - j
        //value is a list for all ele in the same diagonal, use a minHeap for sorting
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<Integer>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }
}