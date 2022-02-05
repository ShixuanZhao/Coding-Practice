class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
	    boolean[][] M = new boolean[m + 1][n + 1];
	    M[0][0] = true;
        for (int i = 1; i <= m; i++) {
            M[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                //match 0 letter
                M[0][j] = M[0][j - 1];
            }
            //other case would be false
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //case1:match 0 letter
                    //case2:match 1 or more letter
                    M[i][j] = M[i][j - 1] || M[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    M[i][j] = M[i - 1][j - 1];
                } else {
                    M[i][j] = false;
                }
            }
        }
        return M[m][n];
    }
}