class Solution {
    /*
    not right
    M[i]:min step from i to 1
    M[i] = M[i / 2] + 1   i is even
    M[i] =  ??? when i is odd
    */
    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } 
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n % 2 == 0) {
            int res = 1 + integerReplacement(n / 2);
            map.put(n, res);
            return res;
        } else {
            int res = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            map.put(n, res);
            return res;
        }
    }
}