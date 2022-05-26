class Solution {
    /*
    for each update[]
    mark start with +val and end + 1 with -val
    0 1 2 3  4
      2 3    -2
    0 2 5  5 3  
    sum:2 3
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            //+=
            res[start] += update[2];
            if (end + 1 < length) {
                res[end + 1] -= update[2];
            }
        }
        //prefixSum
        int sum = 0;
        for (int i = 0; i < length; i++) {
            res[i] = sum + res[i];
            sum = res[i];
        }
        return res;
    }
}