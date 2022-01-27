class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        //最多有这么多位，从后往前计算，前面补0
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int temp1 = num1.charAt(i) - '0';
                int temp2 = num2.charAt(j) - '0';
                int mul = temp1 * temp2;
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                //must add the original value
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int cur : res) {
            //we do not append leading zero
            if (!(sb.length() == 0 && cur == 0)) {
                sb.append(cur);
            }
        }
        //edge case: 100 * 0 = 000, we should return 0
        return sb.length() == 0 ? "0" : sb.toString();  
     }
}