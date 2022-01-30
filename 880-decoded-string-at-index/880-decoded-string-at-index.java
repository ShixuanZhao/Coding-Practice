class Solution {
    /*
    We decode the string and N keeps the length of decoded string, until N >= K.
Then we go back from the decoding position.
If it's S[i] = d is a digit, then N = N / d before repeat and K = K % N is what we want.
If it's S[i] = c is a character, we return c if K == 0 or K == N
    */
      public String decodeAtIndex(String S, int K) {
        int i;
        long N = 0;
        for (i = 0; N < K; i++) {
            N = Character.isDigit(S.charAt(i)) ? N * (S.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                N /= S.charAt(i) - '0';
                K %= N;
            }
            else {
                if (K % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(S.charAt(i));
    }
}