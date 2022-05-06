class Solution {
    /*
    follow up，如果string里有小数点怎么办。想法是将两个string在小数点位置对齐，然后跟第一问一样相应位数相加。小数点后面位数多的那个，余下的部分直接append到result里。
        23.343555
    243235.235
    */
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
    
//follow-up:decimal
//     public class Main {
    
    
//     public static String addStrings(String num1, String num2) {
        
//         int p1 = num1.length()-1;
//         int p2 = num2.length()-1;
//         StringBuilder sb = new StringBuilder();
        
//         //hanlding decimal first
//         int d1 = num1.indexOf(".");
//         int d2 = num2.indexOf(".");
        
//         int decimalLength1 = num1.length()-d1;
//         int decimalLength2 = num2.length()-d2;
        
//         if(decimalLength1 > decimalLength2){
//             int diff = decimalLength1 - decimalLength2;
//             sb.append(num1.substring(num1.length()-diff,num1.length()));
//             p1 = num1.length()-diff-1;
//         }
//         else{
//             int diff = decimalLength2 -decimalLength1;
//             sb.append(num2.substring(num2.length()-diff,num2.length()));
//             p1 = num2.length()-diff-1;
//         }
//         sb.reverse();       //since this is in order but we will revese the string at the end.
//         int carry = 0;
        
//         //now its normal string addition
//         while(p1>=0 || p2>=0){
            
//             if(num1.charAt(p1)=='.'){
//                 sb.append(".");
//                 p1--; p2--;
//                 continue;
//             }
//             int v1 = p1 >=0 ? (num1.charAt(p1) - '0') : 0;
//             int v2 = p2 >=0 ? (num2.charAt(p2) - '0') : 0;
//             int sum = (v1 + v2 + carry)%10;
//             carry = (v1 + v2 + carry)/10;
//             sb.append(sum);
//             p1--; p2--;
//         }
//         if(carry>0)
//             sb.append(carry);
//         return sb.reverse().toString();
//     }
    
    
//     public static void main(String[] args) {
//         System.out.println(addStrings("234.6387","923.600"));
//     }
// }
