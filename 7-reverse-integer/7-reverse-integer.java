class Solution {
    //负数的除法 -123 / 10 = -12.....-3
    public int reverse(int x) {
        long res = 0;
        for (int i = x; i != 0; i /= 10) {
            res = res * 10 + i % 10;
        }
        return (int)res != res ? 0 : (int)res;
    }
}