class Solution {
    /*
    ["a","b","ba","bca","bda","bdca"]
                                 i
    1.sort by length, use a set to record all the words
    2.delete oen letter, check all possible word after deletion whether in the set
    */
    //M[i]: the longest chain ending at index i(including)
    //M[i] = Math.max(M[j]) words[j] and words[i] are predecessor
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] M = new int[n];
        int res = 1;
        Arrays.fill(M, 1);
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isP(words[i], words[j])) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            System.out.println(M[i]);
            res = Math.max(res, M[i]);
        }
        return res;
    }
    
    /*
    bda
       i
    bdca
        j
     cnt:1
    */
    private boolean isP(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == n2) {
            return false;
        }
        //s1 is the longer one
        int i = 0;
        int j = 0;
        //the number of letter in s2 has been ignored
        int cnt = 0;
        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
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