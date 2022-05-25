class Solution {
//     public String decodeString(String s) {
//         int[] cur = new int[1];
//         return decodeString(s, cur);
//     }
    
//     private String decodeString(String s, int[] cur) {
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
//         while (cur[0] < s.length()) {
//             char c = s.charAt(cur[0]++);
//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0');
//             } else if (c == '[') {
//                 String temp = decodeString(s, cur);
//                 for (int i = 0; i < num; i++) {
//                     sb.append(temp);
//                 }
//                 num = 0;
//             } else if (Character.isLetter(c)) {
//                 sb.append(c);
//             } else {
//                 break;
//             }
//         }
//         return sb.toString();
//     }
    
    public String decodeString(String s) {
         StringBuilder cur = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                //find the matching ]
                int begin = i;
                i++;
                int count = 1; 
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;

                String substr = decodeString(s.substring(begin + 1, i));
                for (int k = 0; k < num; k++) {
                    cur.append(substr);
                }
                num = 0;
            } else { 
                cur.append(s.charAt(i));
            }
        }
        return cur.toString();
    }
}