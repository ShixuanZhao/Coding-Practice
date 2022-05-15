class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        //two pass left sum and right sum
        int[] left = new int[n];
        int[] right = new int[n];
        //running cnt
        int cnt = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + cnt;
            cnt += boxes.charAt(i) - '0';
        }
        cnt = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + cnt;
            cnt += boxes.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}
