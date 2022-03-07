class Solution {
    //longest inscreasing subsequence
    //逆向思维：删除一个，从后往前从长变短的一个chain
    //M[i]:the longest chain starting from index i(begin to delete)
    //M[i] = MAX(M[j] + 1) words[j] can be obtained by deleting a letter from words[i]
    //sort by length, liear scan the words have smaller length
    //i scan from left to right, j scan from i - 1
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int res = 1;
        int n = words.length;
        int[] M = new int[n];
        for (int i = 0; i < n; i++) {
            //initialize
            M[i] = 1;
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isPredecessor(words[j], words[i])) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            res = Math.max(res, M[i]);
        }
        return res;
    }
    
    private boolean isPredecessor(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == n2) {
            return false;
        }
        int i = 0;
        int j = 0;
        //number of diff letter
        int cnt = 0;
        while (i < n1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}