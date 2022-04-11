class Solution {
//     Initial result array.
// Loop twice on the string S.
// First forward pass to find shortest distant to character on left.
// Second backward pass to find shortest distant to character on right.
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        //index of last seen position on the left side
        int pos = -n;
        //forward
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = i - pos;
        }
        //backward
        //index of last seen position on the left side
        for (int i = pos - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}