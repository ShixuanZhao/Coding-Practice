class Solution {
    /*
    "What makes this problem hard is that we have negative values.
    Minimum Size Subarray Sum
    Calculate prefix sum B of list A.
B[j] - B[i] represents the sum of subarray A[i] ~ A[j-1]
Deque d will keep indexes of increasing B[i].
For every B[i], we will compare B[i] - B[d[0]] with K.
    */
    //https://www.youtube.com/watch?v=HeFW6EPBGBg
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length, res = N + 1;
        //prefixSum
        long[] B = new long[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + nums[i];
        //store index, increasing monotonic stack,双端队列
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  k)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}