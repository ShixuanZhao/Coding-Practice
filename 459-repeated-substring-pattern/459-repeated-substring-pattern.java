class Solution {
//     The length of the repeating substring must be a divisor of the length of the input string
// Search for all possible divisor of str.length, starting for length/2
// If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
// If the repeated substring is equals to the input str return true
//     public boolean repeatedSubstringPattern(String str) {
// 	int l = str.length();
// 	for(int i=l/2;i>=1;i--) {
// 		if(l%i==0) {
// 			int m = l/i;
// 			String subS = str.substring(0,i);
// 			StringBuilder sb = new StringBuilder();
// 			for(int j=0;j<m;j++) {
// 				sb.append(subS);
// 			}
// 			if(sb.toString().equals(str)) return true;
// 		}
// 	}
// 	return false;
// }
    
    /*
    check each pattern len from 1 to n / 2
    (ab)ababab
        ij
    */
    public boolean repeatedSubstringPattern(String str) {
        int n = str.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }
            String pattern = str.substring(0, len);
            int i = 0;
            int j = len - 1;
            while (j < n) {
                if (!pattern.equals(str.substring(i, j + 1))) {
                    break;
                }
                i += len;
                j += len;
            }
            if (i == n) {
                return true;
            }
        }
        return false;
    }
}