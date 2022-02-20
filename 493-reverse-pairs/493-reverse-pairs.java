class Solution {
	// Explanation: In each round, we divide our array into two parts and sort them. 
	// So after "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", 
	// the left part and the right part are sorted and now our only job is to count 
	// how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
    
    // public int reversePairs(int[] nums) {
    //     return mergeSort(nums, 0, nums.length-1);
    // }
    // private int mergeSort(int[] nums, int s, int e){
    //     if(s>=e) return 0; 
    //     int mid = s + (e-s)/2; 
    //     int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
            //both of left part and right part are sorted
    //     for(int i = s, j = mid+1; i<=mid; i++){
    //         while(j<=e && nums[i]/2.0 > nums[j]) j++; 
    //         cnt += j-(mid+1); 
    //     }
    //     Arrays.sort(nums, s, e+1); 
    //     return cnt; 
    // }
    
//     //Or:
// Because left part and right part are sorted, you can replace the Arrays.sort() 
// part with a actual merge sort process. The previous version is easy to write, while this one is faster.
    public int reversePairs(int[] nums) {
        int n = nums.length;
        //a global var
        int[] helper = new int[n];
        for (int i = 0; i < n; i++) {
            helper[i] = nums[i];
        }
        return mergeSort(nums, 0, n - 1, helper);
    }
    
    private int mergeSort(int[] nums, int left, int right, int[] helper) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int cnt = mergeSort(nums, left, mid, helper) + mergeSort(nums, mid + 1, right, helper);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        merge(nums, left, mid, right, helper);
        return cnt;
    }
    
    private void merge(int[] nums, int left, int mid, int right, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = nums[i];
        }
        //pointer for left part
        int p1 = left;
        //pointer for right part
        int p2 = mid + 1;
        //pointer for sorted array
        int i = left;
        while (p1 <= mid && p2 <= right) {
            if (helper[p1] <= helper[p2]) {
                nums[i++] = helper[p1++];
            } else {
                nums[i++] = helper[p2++];
            }
        }
        while (p1 <= mid) {
            nums[i++] = helper[p1++];
        }
        while (p2 <= right) {
            nums[i++] = helper[p2++];
        }
    }
}