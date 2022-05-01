class Solution {
    /*
    int i: the latest position of word1 in string arr
    int j: the latest position of word2
    initial: i = -1 j = -1
    update the dis when either is updated
    ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
                                       j        i
    dis:1
    */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                p1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}