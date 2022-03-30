class Solution {
//     public int maximumSwap(int num) {
//         //M1:brute force
//         //从左往右遍历每个位置，找后面的比他的数字，相同的选最后一次出现的位置，swap
//         char[] nums = String.valueOf(num).toCharArray();
//         dfs(nums, 0);
//         return Integer.valueOf(new String(nums));
//     }
    
//     private void dfs(char[] nums, int index) {
//         if (index == nums.length) {
//             return;
//         }
//         // try to find a number greater than the current
//         // note, if there are several max numbers we need to take the last one,
//         // e.g. 1993->9913 rather than 9193
//         int maxIndex = index;
//         for (int i = index + 1; i < nums.length; i++) {
//             //>=
//             if (nums[i] > nums[index] && nums[i] >= nums[maxIndex]) {
//                 maxIndex = i;
//             }
//         }
//         //find
//         if (maxIndex > index) {
//             char temp = nums[index];
//             nums[index] = nums[maxIndex];
//             nums[maxIndex] = temp;
//             return;
//         }
//         dfs(nums, index + 1);
//     }
    
    // public int maximumSwap(int num) {
    //     //Use buckets to record the last position of digit 0 ~ 9 in this num.
    //     // Loop through the num array from left to right. For each position, 
    //     // we check whether there exists a larger digit in this num (start from 9 to current digit). 
    //     // We also need to make sure the position of this larger digit is behind the current one. 
    //     // If we find it, simply swap these two digits and return the result.
    //     char[] arr = Integer.toString(num).toCharArray();
    //     int[] bucket = new int[10];
    //     //find the last occurence index for each digit
    //     for (int i = 0; i < arr.length; i++) {
    //         bucket[arr[i] - '0'] = i;
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 9; j > arr[i] - '0'; j--) {
    //             if (bucket[j] > i) {
    //                 char temp = arr[i];
    //                 arr[i] = arr[bucket[j]];
    //                 arr[bucket[j]] = temp;
    //                 return Integer.valueOf(new String(arr));
    //             }
    //         }
    //     }
    //     return num;
    // }
    
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        dfs(arr, 0);
        return Integer.valueOf(new String(arr));
    }
    
    private void dfs(char[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        //find the index of the largest greater ele
        int maxIndex = index;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index] && arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
        }
        if (maxIndex != index) {
            char temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            return;
        }
        dfs(arr, index + 1);
    }
}