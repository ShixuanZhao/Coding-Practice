class Solution {
    //M[i] = M[i - 1] + M[i - 2] if the last one letter and last two letter is valid
    public int numDecodings(String s) {
        int n = s.length();
        int[] M = new int[n + 1];
        ///!!!
        M[0] = 1;
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            M[1] = 1;
        }
        //i is the size
        for (int i = 2; i <= n; i++) {
            //右小段可以选一个letter可以选2个letter
            //1 digit cur val
            int a = s.charAt(i - 1) - '0';
            //2 digits cur and prev val
            int b = (s.charAt(i - 2) - '0') * 10 + a;
            if (a >= 1 && a <= 9) {
                M[i] = M[i - 1];
            }
            if (b >= 10 && b <= 26) {
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