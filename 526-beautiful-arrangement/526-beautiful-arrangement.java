class Solution {
    //M1
//     int res = 0;
//     public int countArrangement(int n) {
//         //1-base
//         boolean[] used = new boolean[n + 1];
//         helper(n, 1, used);
//         return res;
//     }
    
//     private void helper(int n, int index, boolean[] used) {
//         if (index == n + 1) {
//             res++;
//             return;
//         }
//         for (int i = 1; i <= n; i++) {
//             if (!used[i] && (i % index == 0 || index % i == 0)) {
//                 used[i] = true;
//                 helper(n, index + 1, used);
//                 used[i] = false;
//             }
//         }
//     }
    int res = 0;
    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        int[] arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        //start from int 1
        helper(arr, 1);
        return res;
    }
    
    private void helper(int[] arr, int index) {
        if (index == arr.length) {
            res++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            if (arr[index] % index == 0 || index % arr[index] == 0) {
                helper(arr, index + 1);
            }
            swap(arr, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}