class Solution {
    //two pointers TWO SUM!!!
    // public boolean judgeSquareSum(int c) {
    //     int n1 = 0, n2 = (int)Math.sqrt(c);
    //     while (n1 <= n2) {
    //         int cur = n1 * n1 + n2 * n2;
    //         if (cur == c) return true;
    //         if (cur < c) n1++;
    //         else n2--;
    //     }
    //     return false;
    // }
    
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}