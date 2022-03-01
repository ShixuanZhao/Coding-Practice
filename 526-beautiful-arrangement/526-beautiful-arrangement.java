class Solution {
    int res = 0;
    public int countArrangement(int n) {
        //1-base
        boolean[] used = new boolean[n + 1];
        helper(n, 1, used);
        return res;
    }
    
    private void helper(int n, int index, boolean[] used) {
        if (index == n + 1) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % index == 0 || index % i == 0)) {
                used[i] = true;
                helper(n, index + 1, used);
                used[i] = false;
            }
        }
    }
}