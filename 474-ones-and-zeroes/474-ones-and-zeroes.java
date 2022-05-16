class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //M[i][j]:the max size of subset of whole strs using at most m 0 and n 1
        int[][] M = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0;
            int one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            //M[i][j] = Math.max(M[i][j], M[i - zero][j - one] + 1)
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    M[i][j] = Math.max(M[i][j], M[i - zero][j - one] + 1);
                }
            }
        }
        return M[m][n];
    }
}