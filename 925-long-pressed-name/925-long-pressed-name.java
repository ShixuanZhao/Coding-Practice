class Solution {
    /*
    saeed
        i
    ssaaeeda
           j
    */
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        if (m > n) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (j < n) {
            if (i < m && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            } else {
                j++;
            }
        }
        return i == m;
    }
}