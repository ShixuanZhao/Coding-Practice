class Solution {
    /*
    abbbca
     i
       j
    */
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int n = s.length();
        int i = 0;
        int j = n - 1;
        //boolean hasDelete = false;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isP(s, i + 1, j) || isP(s, i, j - 1);
            } 
        }
        return true;
    }
    
    private boolean isP(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}