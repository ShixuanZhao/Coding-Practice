class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 0) {
            return num2;
        }
        if (n2 == 0) {
            return num1;
        }
        int carry = 0;
        int i = n1 -1;
        int j = n2 - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
            sum = 0;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}