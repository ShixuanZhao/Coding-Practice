class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
	    boolean[][] M = new boolean[m + 1][n + 1];
        M[0][0] = true;
        for (int i = 1; i <= m; i++) {
            M[i][0] = false;
        }
        //"" ***
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                M[0][i] = M[0][i - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //case1: aa aa | ab a?
                //compare the ending letter of s and p
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    M[i][j] = M[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //abc * M[i - 1][j]| ab a* M[i - 1][j - 1] | ab ab* M[i][j - 1] 
                    M[i][j] = M[i - 1][j] || M[i - 1][j - 1] || M[i][j - 1];
                } else {
                    M[i][j] = false;
                }
            }
        }
        return M[m][n];
    }
}