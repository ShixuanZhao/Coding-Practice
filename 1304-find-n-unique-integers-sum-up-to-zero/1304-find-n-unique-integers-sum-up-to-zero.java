class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        while (i < j) {
            res[i] = j;
            res[j] = -j;
            i++;
            j--;
        }
        return res;
    }
}