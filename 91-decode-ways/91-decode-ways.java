class Solution {
    /*
    M[i]:the number of way for substring(0, i]
    if s[i] is in 1-9 M[i] = M[i - 1]
    if s[i - 1, i] is in 10 -26 M[i] += M[i - 2]
    */
    public int numDecodings(String s) {
        int n = s.length();
        int[] M = new int[n + 1];
        M[0] = 1;
        if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
            M[1] = 1;
        }
        //i is the number of char
        for (int i = 2; i <= n; i++) {
            //bug: char to int will convert to ASCII
            //int oneChar = Integer.valueOf(s.charAt(i - 1));
            int oneChar = s.charAt(i - 1) - '0';
            int twoChar = Integer.valueOf(s.substring(i - 2, i));
            if (oneChar > 0 && oneChar <= '9') {
                M[i] = M[i - 1];
            }
            if (twoChar >= 10 && twoChar <= 26) {
                M[i] += M[i - 2];
            }
        }
        return M[n];
    }
}