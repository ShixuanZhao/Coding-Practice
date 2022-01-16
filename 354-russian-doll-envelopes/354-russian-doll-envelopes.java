class Solution {
    // This problem is asking for LIS in two dimensions, width and height. Sorting the width reduces the problem by one dimension. If width is strictly increasing, the problem is equivalent to finding LIS in only the height dimension. However, when there is a tie in width, a strictly increasing sequence in height may not be a correct solution. For example, [[3,3] cannot fit in [3,4]].(must greater) Sorting height in descending order when there is a tie prevents such a sequence to be included in the solution.
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
           if (a[0] != b[0]) {
               return a[0] - b[0];
           } else {
               return b[1] - a[1];
           }
        });
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = envelopes[i][1];
        }
        return LIS(arr);
    }
    
    private int LIS(int[] arr) {
        int[] M = new int[arr.length];
        Arrays.fill(M, 1);
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            res = Math.max(res, M[i]);
        }
        return res;
    }
}