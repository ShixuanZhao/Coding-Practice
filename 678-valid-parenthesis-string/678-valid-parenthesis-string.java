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
    
    public boolean checkValidString(String s) {
        //num of open '('
        int min = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else {
                max++;
                min--;
            }
            if (max < 0) {
                return false;
            }
            min = Math.max(min, 0);
        }
        return min == 0;
    }
}