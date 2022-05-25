class Solution {
    public String decodeString(String s) {
        int[] cur = new int[1];
        return decodeString(s, cur);
    }
    
    private String decodeString(String s, int[] cur) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (cur[0] < s.length()) {
            char c = s.charAt(cur[0]++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                String temp = decodeString(s, cur);
                for (int i = 0; i < num; i++) {
                    sb.append(temp);
                }
                num = 0;
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}