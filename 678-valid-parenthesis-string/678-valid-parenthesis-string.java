class Solution {
    /*
        dfs:choose 3 choices that '*' can choose
        dfs(String s, int begin, int cnt)
        use cnt to record the state
        if we meet (, cnt++
        if we meet ), cnt--
        if we meed *, try 3 possibility
        if at last, judge whether cnt == 0
        T = O(3^n)
    */
    //TLE
//     public boolean checkValidString(String s) {
//         return dfs(s, 0, 0);
//     }
    
//     private boolean dfs(String s, int begin, int cnt) {
//         if (cnt < 0) {
//             return false;
//         }
//         for (int i = begin; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 cnt++;
//             } else if (s.charAt(i) == ')') {
//                 cnt--;
//                 if (cnt < 0) {
//                     return false;
//                 }
//             } else if (s.charAt(i) == '*') {
//                 return dfs(s, i + 1, cnt + 1) || dfs(s, i + 1, cnt - 1) || dfs(s, i + 1, cnt);
//             }
//         }
//         return cnt == 0;
//     }
    
    //best solution:counting
    // public boolean checkValidString(String s) {
    //     int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             cmax++;
    //             cmin++;
    //         } else if (c == ')') {
    //             cmax--;
    //             cmin--;
    //         } else if (c == '*') {
    //             cmax++; // if `*` become `(` then openCount++
    //             cmin--; // if `*` become `)` then openCount--
    //             // if `*` become `` then nothing happens
    //             // So openCount will be in new range [cmin-1, cmax+1]
    //         }
    //         if (cmax < 0) return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid
    //                                     // For example: ())(
    //         cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
    //     }
    //     return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    // }

    //DP T = O(n^3) S = O(n^2)
    //case1:L()R  L:( or *    R:) or * M[i][j] depend on M[i + 1][j - 1] 
    //case2:()|()
    //        k    M[i][k] && M[k + 1][j]
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] M = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                M[i][i] = true;
            }
            for (int j = i + 1; j < n; j++) {
                //case1:
                char left = s.charAt(i);
                char right = s.charAt(j);
                if (left != ')' && right != '(') {
                    if (j - i < 2 || M[i + 1][j - 1]) {
                        M[i][j] = true;
                        continue;
                    }
                }
                //enumerate k
                for (int k = i; k < j; k++) {
                    if (M[i][k] && M[k + 1][j]) {
                        M[i][j] = true;
                        break;
                    }
                }
            }
        }
        return M[0][n - 1];
    }
}