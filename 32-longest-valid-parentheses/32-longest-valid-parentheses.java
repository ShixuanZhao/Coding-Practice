class Solution {
    /*
    use 2 pass to check all invalid ( and )
    step1:scan from left to right, count the num of valid () imagine we remove all invalid ")"
    ( ) )    cntL, cntR   if == , update res num
        i       1      2    if cntR > cntL, invald reset our counter
    step2: scan from right to left, update res, imagine we remove all the invalid (
    (()
    T = O(n)  S = O(1)
    */
    public int longestValidParentheses(String s) {
        //corner case
        if (s == null || s.length() == 1) {
            return 0;
        }
        int res = 0;
        int cntL = 0;
        int cntR = 0;
        //step1
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cntL += 1;
            } else {
                cntR += 1;
            }
            if (cntL == cntR) {
                res = Math.max(res, 2 * cntL);
            }
            if (cntR > cntL) {
                cntL = 0;
                cntR = 0;
            }
        }
        cntL = 0;
        cntR = 0;
        //step2:
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                cntL += 1;
            } else {
                cntR += 1;
            }
            if (cntL == cntR) {
                res = Math.max(res, 2 * cntL);
            }
            if (cntR < cntL) {
                cntL = 0;
                cntR = 0;
            }
        }
        return res;
    }
}