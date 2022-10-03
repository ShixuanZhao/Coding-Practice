class Solution {
    /*
    Do you still remember how did you solve this problem? https://leetcode.com/problems/word-break/
If you do know one optimized solution for above question is using DP, 
this problem is just one more step further. We iterate through each word and see if it can be formed by using other words.
Of course it is also obvious that a word can only be formed by words shorter than it. 
So we can first sort the input by length of each word, and only try to form one word by using words in front of it.
    */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return res;
        }
        Set<String> prevSet = new HashSet<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (String s : words) {
            //set里面都睡比他短的word
            if (canBreak(s, prevSet)) {
                res.add(s);
            }
            //再放进去
            prevSet.add(s);
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
    private boolean canBreak(String s, Set<String> dict) {
        //this case can not be ignored
        if (dict.size() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] M = new boolean[n + 1];
        M[0] = true;
        for (int i = 1; i <= n; i++) {
            //j is the size of left big part
            for (int j = 0; j < i; j++) {
                if (M[j] && dict.contains(s.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[n];
    }
}