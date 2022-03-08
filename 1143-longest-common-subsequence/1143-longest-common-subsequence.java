class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //edit distance
        /*
        xxxxxA
        yyyyyB
        */
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int len = 0;
        int[][] M = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                }
            }
        }
        return M[t1.length][t2.length];
    }
}