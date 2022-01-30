class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n > 0) {
            n -= i;
            i++;
        }
        return n == 0 ? i - 1 : i - 2;
    }
}