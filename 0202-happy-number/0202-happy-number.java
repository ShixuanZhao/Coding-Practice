class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int cur = 0;
            for (int i = n; i > 0; i /= 10) {
                cur += (i % 10) * (i % 10);
            }
            if (cur == 1) {
                return true;
            }
            if (set.contains(cur)) {
                return false;
            }
            set.add(cur);
            n = cur;
        }
    }
}