class Solution {
    /*
    n = 10
    1 2 3 4 5 6 7 8 9 
      T T F T F T F F 
    */
    public int countPrimes(int n) {
        //         首先从 2 开始，我们知道 2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8… 都不可能是素数了。

// 然后我们发现 3 也是素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12… 也都不可能是素数了。
        //排除法
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}