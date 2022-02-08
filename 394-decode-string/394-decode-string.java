class Solution {
    public String decodeString(String s) {
        //store the current index when iterating the char array
        //必须用全局的pointer，因为break之后return到上一层，需要从右括号下一个位置开始遍历，需要全局的pointer来记录
        //因为我的pointer要一直从左往右走到头的，不存在往回backtracking，不存在做选择所以要全局的，遇到右括号是结果返回了
        //但是pointer不应该返回
        int[] cur = new int[1];
        char[] array = s.toCharArray();
        return helper(array, cur);
    }
    
    private String helper(char[] array, int[] cur) {
        //note: StringBuilder is not a global variable, every recursion call has a StringBuilder
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (cur[0] < array.length) {
            char c = array[cur[0]++];
            if (Character.isDigit(c)) {
                //remember to convert to number accumulately
                num = num * 10 + c - '0';
                
            } else if (c == '[') {
                
                String temp = helper(array, cur);
                for (int i = 0; i < num; i++) {
                    sb.append(temp);
                }
                num = 0;
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
                
            } else {
                //cur[0] refers to ']'
                
                break;
            }
        }
        return sb.toString();
    }
//     public String decodeString(String s) {
//         Queue<Character> q = new ArrayDeque<>();
//         for (char c : s.toCharArray()) {
//             q.offer(c);
//         }
//         return helper(q);
//     }
    
//     private String helper(Queue<Character> q) {
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
//         while (!q.isEmpty()) {
//             char c = q.poll();
//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0');
//             } else if (Character.isLetter(c)) {
//                 sb.append(c);
//             } else if (c == '[') {
//                 String sub = helper(q);
//                 for (int i = 0; i < num; i++) {
//                     sb.append(sub);
//                 }
//                 //!!!reset the counter
//                 num = 0;
//             } else {
//                 break;
//             }
//         }
//         System.out.println(sb.toString().length());
//         return sb.toString();
//     }
}


