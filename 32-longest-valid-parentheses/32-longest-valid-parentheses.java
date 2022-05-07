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
    // public int longestValidParentheses(String s) {
    //     //corner case
    //     if (s == null || s.length() == 1) {
    //         return 0;
    //     }
    //     int res = 0;
    //     int cntL = 0;
    //     int cntR = 0;
    //     //step1
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             cntL += 1;
    //         } else {
    //             cntR += 1;
    //         }
    //         if (cntL == cntR) {
    //             res = Math.max(res, 2 * cntL);
    //         }
    //         if (cntR > cntL) {
    //             cntL = 0;
    //             cntR = 0;
    //         }
    //     }
    //     cntL = 0;
    //     cntR = 0;
    //     //step2:
    //     for (int i = s.length() - 1; i >= 0; i--) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             cntL += 1;
    //         } else {
    //             cntR += 1;
    //         }
    //         if (cntL == cntR) {
    //             res = Math.max(res, 2 * cntL);
    //         }
    //         if (cntR < cntL) {
    //             cntL = 0;
    //             cntR = 0;
    //         }
    //     }
    //     return res;
    // }
    
//      The main idea is as follows: I construct a array longest[], for any longest[i], it stores the longest length of valid parentheses which is end at i.
// And the DP idea is :
// If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.
// Else if s[i] is ')'
//      If s[i-1] is '(', longest[i] = longest[i-2] + 2
//      Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
// For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.
    
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else {
                    int prevLen = dp[i - 1];
                    if (prevLen > 0 && i - prevLen - 1 >= 0 && s.charAt(i - prevLen - 1) == '(') {
                        dp[i] = 2 + prevLen + (i - prevLen - 2 >= 0 ? dp[i - prevLen - 2] : 0);
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}