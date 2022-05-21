class Solution {
    //2次单调栈，1 next smaller ele 2 prev smaller ele use 2 arr
    // res = sum(A[i] * f(i))
    // where f(i) is the number of subarrays,
    // in which A[i] is the minimum.
    /*
     0 1 2 3 4  
    [3,1,2,4]
        ik   j
        [2] [2 4]
        (k - i) * (j - k) = 1 * 2 = 2
        看每个ele对于整体sum的贡献，就是以每个ele为中心找到prev lesser和next lesser就找到了左右边界
        （i..ele...j）not including，然后做排列组合
        [71,55,82,55]
        left: [-1, -1, 1, 1]
              
              0  1   2  3
             [71,55,82,55]
        left  -1 -1 1  1
        right  1  3 3 4
        res = 71 + 4 * 55 + 82 + 2 * 55 = 483 but the right ans is 593
        because the first 55 the right bound should be 4 not 3
        so when we build left[] and right[], we should let one strictly >=, the another one should be <
    */
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = arr.length;
        //prev lesser
        int[] left = new int[n];
        int[] right = new int[n];
        //do not forget to initialize the left[] and right[]
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        //store the index
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            //there can be duplicate number, so = is ok
            while (!stack.isEmpty() && arr[stack.peekFirst()] >= arr[i]) {
                left[stack.pollFirst()] = i;
            }
            stack.offerFirst(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            //if when we build left making >=, this round must >, otherwise there would be duplicate subarray
            //like two [71,55,82,55]
            while (!stack.isEmpty() && arr[stack.peekFirst()] > arr[i]) {
                right[stack.pollFirst()] = i;
            }
            stack.offerFirst(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return (int)res;
    }
}