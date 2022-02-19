class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        helper(array, res, 0, 0, sb);
        return res;
    }

    private void helper(char[] array, List<String> res, int level, int begin, StringBuilder sb) {
        int len = sb.length();
        if (level == 4) {
            if (len == array.length + 3) {
                res.add(sb.toString());
            }
            return;
        }
        if (begin < array.length) {
            char a = array[begin];
            sb.append(a).append(level < 3 ? "." : "");
            helper(array, res, level + 1, begin + 1, sb);
            sb.setLength(len);
        }
        if (begin + 1 < array.length) {
            char a = array[begin];
            char b = array[begin + 1];
            if (a != '0') {
                sb.append(a).append(b).append(level < 3 ? "." : "");
                helper(array, res, level + 1, begin + 2, sb);
                sb.setLength(len);
            }
        }
        if (begin + 2 < array.length) {
            char a = array[begin];
            char b = array[begin + 1];
            char c = array[begin + 2];
            //035 is not right
            // int temp = (a - '0') * 100 + (b - '0') * 10 + c - '0';
            // if (temp >= 0 && temp <= 255) {
            //     sb.append(a).append(b).append(c).append(level < 3 ? "." : "");
            //     helper(array, res, level + 1, begin + 3, sb);
            //     sb.setLength(len);
            // }
            if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
                sb.append(a).append(b).append(c).append(level < 3 ? "." : "");
                helper(array, res, level + 1, begin + 3, sb);
                sb.setLength(len);
            }
        }
    
    }
}