class Solution {
    /*
    M[i][j]:whether isInterleave using the first i letter in s1 and first j letter in s2 composing the first i + j letter in s3
    M[i][j] = M[i - 1][j] if s1.charAt(i - 1) == s3.charAt(i + j - 1)
            = M[i][j - 1]  ...
            else false
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if (m + n != k) {
            return false;
        }
        boolean[][] M = new boolean[m + 1][n + 1];
        M[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                M[i][0] = M[i - 1][0];
            } else {
                M[i][0] = false;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                M[0][i] = M[0][i - 1];
            } else {
                M[0][i] = false;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                //     M[i][j] = M[i - 1][j];
                // } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                //     M[i][j] = M[i][j - 1];
                // } else {
                //     M[i][j] = false;
                // }
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                int c3 = s3.charAt(i + j - 1);
                // If c3 matches c1, then is every char before c1 in s1 valid?
                // If c3 matches c2, then is every char before c2 in s2 valid?
                M[i][j] = (c1 == c3 && M[i - 1][j]) || (c2 == c3 && M[i][j - 1]);
            }
        }
        return M[m][n];
    }
}