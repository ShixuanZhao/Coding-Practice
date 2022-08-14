class Solution {
    /*
     Let's see what are all the possible characters in the input string:
Whitespaces (' ')
Digits ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
A sign ('+' or '-')
Anything else (alphabetic characters, symbols, special characters, etc.)
    */
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
    
//     public int myAtoi(String str) {
//         int index = 0;
//         int total = 0;
//         int sign = 1;
        
//         // Check if empty string
//         if(str.length() == 0)
//             return 0;
        
//         // remove white spaces from the string
//         while(index < str.length() && str.charAt(index) == ' ')
//             index++;
        
//         if (index == str.length()) return 0;
        
//         // get the sign
//         if(str.charAt(index) == '+' || str.charAt(index) == '-') {
//             sign = str.charAt(index) == '+' ? 1 : -1;
//             index++;
//         }
        
//         // convert to the actual number and make sure it's not overflow
//         while(index < str.length()) {
//             int digit = str.charAt(index) - '0';
//             if(digit < 0 || digit > 9) break;
            
//             // check for overflow before *10
//             if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
//                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//             //may be overflow
//             total = total*10 + digit;
//             index++; // don't forget to increment the counter
//         }
//         return total*sign;
//     }
}