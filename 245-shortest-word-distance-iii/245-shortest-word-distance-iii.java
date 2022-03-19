class Solution {
    //i1 and i2 are the indexes where word1 and word2 were last seen. Except if they're the same word, then i1 is the previous index.
    /*
        ["practice", "makes", "perfect", "coding", "makes"]
                       i1                            i2
    */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        //index for word1
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                //deal with corner case
                if (word2.equals(word1)) {
                    //p1 become the previous one
                    p1 = p2;
                }
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}