class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int n = str.length();
        int sign = 1;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        int res = 0;
        while (i < n) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            int temp = res;
            res = res * 10 + digit;
            if (res < 0 || (res - digit) / 10 != temp) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return sign * res; 
    }
}