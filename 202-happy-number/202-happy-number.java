class Solution {
    //The idea is to use one hash set to record sum of every digit square of every number occurred. Once the current sum cannot be added to set, return false; once the current sum equals 1, return true;
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (!set.add(n)) {
                return false;
            }
            int squareSum = 0;
            for (int i = n; i != 0; i /= 10) {
                squareSum += (i % 10) * (i % 10);
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
    }
}