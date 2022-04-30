class Solution {
    /*
    这个算法要我们做的是找到一些分裂线，这样这条线左边的数字都小于这条线右边的数字。这个想法与快速排序非常相似。
    the basic idea is to use max[] array to keep track of the max value until the current position, and compare it to the sorted array (indexes from 0 to arr.length - 1). 
	If the max[i] equals the element at index i in the sorted array, then the final count++.
    original: 0, 2, 1, 4, 3, 5, 7, 6
    max:      0, 2, 2, 4, 4, 5, 7, 7
    sorted:   0, 1, 2, 3, 4, 5, 6, 7
    index:    0, 1, 2, 3, 4, 5, 6, 7
    */
    public int maxChunksToSorted(int[] arr) {
       int n = arr.length;
        //max record the max value from index 0 to cur position(including)
        //because range [0, n - 1], we do not need to sort it, just compare max with index(after sortint val)
        int max = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                cnt++;
            }
        }
        return cnt;
    }
}