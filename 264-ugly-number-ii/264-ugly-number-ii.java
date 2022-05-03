class Solution {
//     The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
// because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
//1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15
    //NOTICE 1 2 3 are not 连续的，他们来源于我们的DP，表示前面的丑数
// (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
//             i
// (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
//             j
// (3) 1×5, 2×5, 3×5, 4×5, 5×5, …(not have 7 * 5 because 7 is not ugly number)
//        k
//    dp[]:1,2 3
//    maintain 3 var represent the val that i j k point to
// We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

// Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

// Every step we choose the smallest one, and move one step after,including nums with same value.
    public int nthUglyNumber(int n) {
        int[] M = new int[n];
        //the index+1 th ugly number
        M[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int val2 = 2;
        int val3 = 3;
        int val5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(val2, val3), val5);
            M[i] = min;
            if (min == val2) {
                //!!important, index must plus first
                //update the index, and update the next ugly number that need to be compare
                val2 = 2 * M[++index2];
            }
            if (min == val3) {
                val3 = 3 * M[++index3];
            }
            if (min == val5) {
                val5 = 5 * M[++index5];
            }
        }
        return M[n - 1];
    }
}