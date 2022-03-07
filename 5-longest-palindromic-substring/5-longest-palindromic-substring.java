class Solution {
    /*
        input: string output:string
        clarify: s == null s.length() == 0
            return ""
        enumrate all the substring,check if the it is palin
        if true, update the maxLen, record the begin letter
        substring(left, right)
        for left in s
            for right in s
                check palir 
        O(n^3)
        
        a(bb)a  is, update the maxLen
        i    j
        a(bb)c  is not palin
        high level:dp
        M[i][j] i < j whether [i, j] is palin
        induction rule: 
        M[i][j] = M[i + 1][j - 1] if char i = char j
                  j - i < 3 aba  aa   true
                            i j  i j
                char i != char j false
        if M[i][j] is true
        update the maxLen record the left ele
        expand from the center and check the edge
        T = O(n^2) S = O(n^2)
    */
    // public String longestPalindrome(String s) {
        // if (s == null || s.length() == 0) {
        //     return "";
        // }
        // int n = s.length();
        // boolean[][] M = new boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     M[i][i] = true;
        // }
        // int begin = 0;
        // //the minimum len is 1
        // int maxLen = 1;
        // for (int j = 1; j < n; j++) {
        //     for (int i = j - 1; i >= 0; i--) {
        //         if (s.charAt(i) == s.charAt(j)) {
        //             //guarantee at least 3 ele
        //             if (j - i < 3) {
        //                 M[i][j] = true;
        //             } else {
        //                 M[i][j] = M[i + 1][j - 1];
        //             }
        //         } else {
        //             M[i][j] = false;
        //         }
        //         if (M[i][j] && j - i + 1 > maxLen) {
        //             begin = i;
        //             maxLen = j - i + 1;
        //         }
        //     }
        // }
        // return s.substring(begin, begin + maxLen);
        
//         int n = s.length();
//         if (n == 1) {
//             return s;
//         }
//         StringBuilder sb = new StringBuilder();
//         int[] maxLen = new int[1];
//         for (int i = 0; i < n; i++) {
//             checkP(s, i, i, sb, maxLen);
//             checkP(s, i, i + 1, sb, maxLen);
//         }
//         return sb.toString();
//     }
    
//     private void checkP(String s, int left, int right, StringBuilder sb, int[] maxLen) {
//         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//             left--;
//             right++;
//         }
//         //(left, right) not include boundary
//         if (maxLen[0] < right - left - 1) {
//             maxLen[0] = right - left - 1;
//             sb.setLength(0);
//             sb.append(s.substring(left + 1, right));
//         }
    
//     }
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] M = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            M[i][i] = true;
        }
        int begin = 0;
        //the minimum len is 1
        int maxLen = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    //guarantee at least 3 ele
                    //only two ele
                    if (j - i < 3) {
                        M[i][j] = true;
                    } else {
                        M[i][j] = M[i + 1][j - 1];
                    }
                } else {
                    M[i][j] = false;
                }
                if (M[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}