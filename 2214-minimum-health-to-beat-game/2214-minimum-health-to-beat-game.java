class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long res = 1;
        int max = 0;
        for (int num : damage) {
            max = Math.max(max, num);
        }
        boolean used = false;
        for (int num : damage) {
           if (!used && num == max) {
               res += Math.max(num - armor, 0);
               used = true;
           } else {
               res += num;
           }
        }
        return res;
    }
}