class Solution {
    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        return (n % 2 == 0 && isUgly(n / 2)) || (n % 3 == 0 && isUgly(n / 3)) || (n % 5 == 0 && isUgly(n / 5));
    }
    
//     public boolean isUgly(int n) {
//         if (n == 0) {
//             return false;
//         }
//         int[] factor = new int[] {2, 3, 5};
//         for (int num : factor) {
//             while (n % num == 0) {
//                 n /= num;
//             }
//         }
//         return n == 1;
//     }
}