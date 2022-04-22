class Solution {
    public int trailingZeroes(int n) {
//         Because all trailing 0 is from factors 5 * 2.
// But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
/*
Trailing 0s in n! = Count of 5s in prime factors of n!
                  = floor(n/5) + floor(n/25) + floor(n/125) + ....
*/
        int cnt = 0;
        //counter the number of 5
        for (int i = 5; i <= n; i *= 5) {
            cnt += n / i;
        }
        return cnt;
    }
}