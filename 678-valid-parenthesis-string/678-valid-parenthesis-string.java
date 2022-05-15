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
    public boolean checkValidString(String s) {
        int cmin = 0;
        int cmax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin--;
                cmax--;
            } else {
                //c == '*'
                cmax++;
                cmin--;
            }
            //too many )
            if (cmax < 0) {
                return false;
            }
            //can choose to * to empty
            if (cmin < 0) {
                cmin = 0;
            }
        }
        return cmin == 0;
    }
}