class Solution {
    /*
    ab 
     i
    acb
     j
     
     ab 
      i
     ac
      j
    */
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (++cnt > 1) {
                    return false;
                }
                if (m == n) {
                    //replace
                    i++;
                    j++;
                } else {
                    //remove from the longer one
                    if (m > n) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }
        }
        // If last character is extra
        // in any string
        // ab  acddd
        //   i   j
        if (i < m || j < n) {
            cnt++;
        }
        return cnt == 1;
    }
}