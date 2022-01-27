class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                mul += res[p2]; 
                res[p2] = mul % 10;
                res[p1] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (!(sb.length() == 0 && res[i] == 0)) {
                sb.append(res[i]);
            }
        }
        //0000 return 0
        return sb.length() == 0 ? "0" : sb.toString();
    }
}