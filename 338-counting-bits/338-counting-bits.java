class Solution {
    /*
    找规律：
    0 0 0 
    1 1 1
    2 10 1
    3 11 2
    4 100 1
    5 101 2
    6 110 2
    */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n > 0) {
            res[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            res[i] = res[i / 2] + res[i % 2];
        }
        return res;
    }
}