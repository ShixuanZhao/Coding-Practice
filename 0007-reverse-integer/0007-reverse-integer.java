class Solution {
    //负数的除法 -123 / 10 = -12.....-3
    // public int reverse(int x) {
    //     long res = 0;
    //     for (int i = x; i != 0; i /= 10) {
    //         res = res * 10 + i % 10;
    //     }
    //     //(int)res != res means it is overflow return 0
    //     return (int)res != res ? 0 : (int)res;
    // }
    
    //Update: Not using long
    public int reverse(int x) {
        int prevRes = 0;
        int res = 0;
        for (int i = x; i != 0; i /= 10) {
            res = res * 10 + i % 10;
            if ((res - i % 10) / 10 != prevRes) {
                return 0;
            }
            prevRes = res;
        }
        return res;
    }
}