class Solution {
    /*
    expand from center for each letter,and there are only 2n - 12n−1 such centers.
    */
    int maxLen = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            expand(s, i, i, sb);
            expand(s, i, i + 1, sb);
        }
        return sb.toString();
    }
    
    private void expand(String s, int i, int j, StringBuilder sb) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            sb.setLength(0);
            sb.append(s.substring(i + 1, j));
        }
    }
}