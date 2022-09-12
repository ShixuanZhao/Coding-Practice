class Solution {
//     Traverse the input s:

// If encontering 0, count subsequences ending at current 0: 0, 10 and 010's; The number of 10 depends on how many 1s before current 0, and the number of 010 depends on how many 01 before current 0;
// Similarly,

// If encontering 1, count subsequences ending at current 1: 1, 01 and 101's; The number of 01 depends on how many 0s before current 1, and the number of 101 depends on how many 10 before current 1.
     public long numberOfWays(String s) {
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zero;
                oneZero += one; // Count in '10'.
                ways += zeroOne; // Count in '010'.
            }else {
                ++one;
                zeroOne += zero; // Count in '01'.
                ways += oneZero; // Count in '101'.
            }
        }
        return ways;
    }
}