class Solution {
    /*
    1.sort the arr by length small to large
    2.do dp:
        M[i] = max len from index 0 to index i(including index i)
        M[i] = Max(M[j] + 1) j < i, i, j are predecessor
        return globalMax
    */
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int[] M = new int[n];
        Arrays.fill(M, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isP(words[i], words[j])) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            res = Math.max(res, M[i]);
        }
        return res;
    }
    
    private boolean isP(String l, String s) {
        if (l.length() == s.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int cnt = 0;
        int m = l.length();
        int n = s.length();
        while (i < m && j < n) {
            if (l.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                if (++cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}