class Solution {
    /*
    M[i][k]:from index0, whether the frog can jump to index i and last jump is k step
    M[0][0] = true;
    M[1][1] = true; suppose stones[1] == 1
    ........|.
             
    check all the previous index j, if stones[j] + k = stone[i]
    M[i][k] = M[j][k - 1] || M[j][k] || M[j][k + 1]
    res: check M[n - 1][all possible step from 1 to n]
    */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        boolean[][] M = new boolean[n][n];
        M[0][0] = true;
        M[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
               if (j + 1 >= k) {
                    M[i][k] = M[j][k - 1] || M[j][k] || M[j][k + 1];
               }
            }
        }
        for (int i = 1; i < n; i++) {
            if (M[n - 1][i]) {
                return true;
            }
        }
        return false;
    }
}