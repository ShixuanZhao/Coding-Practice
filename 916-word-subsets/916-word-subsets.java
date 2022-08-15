class Solution {
    /*
    BruteForce: check for every word with complete B array.
amazon -> check ec present , then check oc , then ceo if any of these false discard amazon.
similar check apple,facebook.. with every word of B
Time:O(A.lengthB.lengthmaxWordlength) . lets move to optimised approch.

Optimal Approch:

eg : A = ["amazon","apple","facebook","google","leetcode"], B = ["eec","oco","ceo"]
we know that order doesn't matter and all word of B are subset of word in A then only that word is considered. Having this in mind lets make a common word through B and just check that word as a subset in A.
Reduce B to a single word bmax as described above, then compare the counts of letters between words a in A, and bmax.

For each word b in B,
we use function counter to count occurrence of each letter.
We take the maximum occurrences of counts, and use it as a filter of A.
Time:O(A+B) and Space:O (1) [ Big O notation 26 is constant space ]
    */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        //single word words2max
        int[] words2max = new int[26];
        for (String s : words2) {
            int[] cur = counter(s);
            for (int i = 0; i < 26; i++) {
                words2max[i] = Math.max(cur[i], words2max[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String w1 : words1) {
            int[] temp = counter(w1);
            int i = 0;
            for (; i < 26; i++) {
                if (temp[i] < words2max[i]) {
                    break;
                }
            }
            if (i == 26) {
                res.add(w1);
            }
        }
        return res;
    }
    
    private int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
}