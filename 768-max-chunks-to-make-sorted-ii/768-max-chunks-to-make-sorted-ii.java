class Solution {
    public int maxChunksToSorted(int[] arr) {
//         Count prefix sum.
// O(nlogn) for sorting
// O(n) for check
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int res = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) res += 1;
        }
        return res;
    }
}