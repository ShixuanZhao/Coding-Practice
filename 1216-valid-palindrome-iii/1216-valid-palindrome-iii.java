class Solution {
    /*
 The idea is to find the longest palindromic subsequence(lps) of the given string.
|lps - original string| <= k,
then the string is k-palindrome.
    longest palindromic subsequence:
    LCS of the given string & its reverse will be the longest palindromic sequence.
     */
    public boolean isValidPalindrome(String s, int k) {
        return s.length() - longestPalindromeSubseq(s) <= k;
    }
    
    /*
    abcdeca
    i
    acedcba
    
    acdca
    */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] M = new int[n][n];
        //M[i][i] = 0
        //根据dp rule的关系：i需要i+1，i从后往前，j需要j-1，j从前往后
        for (int i = n - 1; i >= 0; i--) {
            M[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    M[i][j] = M[i + 1][j - 1] + 2;
                } else {
                    M[i][j] = Math.max(M[i+1][j], M[i][j-1]);
                }
            }
        }
        return M[0][n - 1];
    }
}