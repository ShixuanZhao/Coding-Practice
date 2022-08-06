class Solution {
    /*
    M[i]:the number of way for substring(0, i]
    if s[i] is in 1-9 M[i] = M[i - 1]
    if s[i - 1, i] is in 10 -26 M[i] += M[i - 2]
    */
    public int numDecodings(String s) {
        int n = s.length();
        int[] M = new int[n + 1];
        M[0] = 1;
        if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
            M[1] = 1;
        }
        //i is the number of char
        for (int i = 2; i <= n; i++) {
            //bug: char to int will convert to ASCII
            //int oneChar = Integer.valueOf(s.charAt(i - 1));
            int oneChar = s.charAt(i - 1) - '0';
            int twoChar = Integer.valueOf(s.substring(i - 2, i));
            if (oneChar > 0 && oneChar <= '9') {
                M[i] = M[i - 1];
            }
            if (twoChar >= 10 && twoChar <= 26) {
                M[i] += M[i - 2];
            }
        }
        return M[n];
    }
    
    //dfs Find all possible decode ways
    /*
           226
       2|26     22|6
    2|2|6 2|26
    */
//     public List<String> numDecodings(String s) {
//         StringBuilder sb = new StringBuilder();
//         List<String> res = new LinkedList<>();
//         dfs(res, sb, 0, s);
//         return res;
//     }
    
//     private void dfs(List<String> res, StringBuilder sb, int index, String s) {
//         if (index == s.length()) {
//             res.add(sb.toString());
//             return;
//         }
//         //one digit
//         int a = s.charAt(index) - '0';
//         if (a >= 1 && a <= 9) {
//             char temp = (char)(a - 1 + 'A');
//             sb.append(temp);
//             dfs(res, sb, index + 1, s);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         if (index + 1 < s.length()) {
//             int b = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
//             if (b >= 10 && b <= 26) {
//                 char temp = (char)(b - 1 + 'A');
//                 sb.append(temp);
//                 dfs(res, sb, index + 2, s);
//                 sb.deleteCharAt(sb.length() - 1);
//             }
//         }
//     }

}