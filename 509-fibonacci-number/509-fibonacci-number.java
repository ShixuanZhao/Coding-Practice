class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] M= new int[n + 1];
        M[1] = 1;
        for (int i = 2; i <= n; i++) {
            M[i] = M[i - 1] + M[i -2];
        }
        return M[n];
    }
}