class Solution {
//     check if GCD (greatest common divisor) of all frequencies is >= 2. Meaning all frequencies are divisible 
// * by some number which is not 1 and >= 2. Say frequencies are [3, 12, 6] we know we can make deck minimum of 3 (as this is the
// * GCD) [3*1, 3*4, 3*2], meaning [1, 4, 2] number of decks of same cards of size 3 is possible.
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }
    //辗转相除法  最大公约数等于a除以b的余数c和b之间的最大公约数
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}