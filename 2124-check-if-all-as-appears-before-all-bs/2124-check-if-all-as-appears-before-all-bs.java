class Solution {
    /*
    You can check the opposite: check if there is a ‘b’ before an ‘a’. Then, negate and return that answer.
    */
    public boolean checkString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                int j = i + 1;
                while (j < s.length()) {
                    if (s.charAt(j) == 'a') {
                        return false;
                    }
                    j++;
                }
                return true;
            }
        }
        return true;
    }
}