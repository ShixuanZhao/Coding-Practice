class Solution {
    /*
    1.sort the words by length, small to large
    [....X...]
    traverse the arr
    store all prev words in a set. check whether X can be concatenated from set
    */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return res;
        }
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (a, b) -> (a.length()) - b.length());
        for (String word : words) {
            if (isPossible(word, set)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }
    
    /*
    without duplicates!!
        cats|dog  [cats, dog]
           j
        M[i]:whether sub word[0, i] can be concatenated
        [0, j](left) [j + 1, end](right)
        left: check from sub problem, right:check whether there is this substring in dict
    */
    private boolean isPossible(String word, Set<String> dict) {
        int n = word.length();
        boolean[] M = new boolean[n + 1];
        M[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && dict.contains(word.substring(j, i))) {
                    M[i] = true;
                }
            }
        }
        return M[n];
    }
}