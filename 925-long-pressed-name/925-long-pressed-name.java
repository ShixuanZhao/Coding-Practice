class Solution {
    /*
    "alex"
         i
    "aaleexa"
           j
    */
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int t = typed.length();
        int i = 0;
        int j = 0;
        while (j < t) {
            if (i < n && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            } else {
                j++;
            }
        }
        return i == n;
    }
}