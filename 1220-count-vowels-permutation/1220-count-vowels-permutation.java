class Solution {
    /*
    M[i]:以char i结尾的permutation的个数
    M[0]:a->e
    M[1]:e->a,i
    M[2]:i->a e o u
    M[3]:o->i u
    M[4]:u->a
    The idea here is to accumulate combinations that ends with a particular letter
    It sounds very similar to 935. Knight Dialer
int[][] moves = { {1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, { 0 } };
顺序型dp
    */
    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long[] M = new long[5];
        Arrays.fill(M, 1);
        for (int i = 2; i <= n; i++) {
            long[] next = new long[5];
            next[0] = (M[1] + M[2] + M[4]) % mod;
            next[1] = (M[0] + M[2]) % mod;
            next[2] = (M[1] + M[3]) % mod;
            next[3] = (M[2]) % mod;
            next[4] = (M[2] + M[3]) % mod;
            M = next;
        }
        long answer = 0;
        for (int i=0; i<5; i++) {
            answer = (answer + M[i]) % mod;
        }
        return (int) answer;
    }
}