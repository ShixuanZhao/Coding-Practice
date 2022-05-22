class Solution {
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        boolean[] M = new boolean[n + 1];
        M[1] = false;
        M[2] = true;
        //i - j 必输
        //那么j的时候一定win
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //both players play optimally.
                if (i % j == 0 && !M[i - j]) {
                    M[i] = true;
                }
            }
        }
        return M[n];
    }
}