class Solution {
    //2次单调栈，1 next smaller ele 2 prev smaller ele use 2 arr
    // res = sum(A[i] * f(i))
    // where f(i) is the number of subarrays,
    // in which A[i] is the minimum.
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = arr.length;
        long res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        //right lesser and left lesser
        //right[i] = j means arr[j] is the next less element of arr[i]
        //left[i]: PLE(previous less element)
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        //right[i], keep a ascending stack
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peekFirst()]) {
                right[stack.pollFirst()] = i;
            }
            stack.offerFirst(i);
        }
        stack.clear();
        //left[i], from right to left, keep an ascending stack
        //in case of duplicated num, we keep strict less when finding left[i]
        //1在6个subarr中都是最小，6 = 2*3
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peekFirst()]) {
                left[stack.pollFirst()] = i;
            }
            stack.offerFirst(i);
        }
        //求出所有以i为min的subarray的sum，i向左右扩散
        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return (int)res;
    }
}