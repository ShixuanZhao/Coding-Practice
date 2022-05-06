class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length();
        int n = abbr.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                //only abbr can be valid number
                if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                    return false;
                }
                int num = 0;
                while (j < n && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
            }
        }
        return i == m && j == n;
    }
}