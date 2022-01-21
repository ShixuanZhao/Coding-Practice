class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         //binary search to find the k-th element
        //k is 1-based
        int m = nums1.length;
        int n = nums2.length;
        int odd = (m + n + 1) / 2;
        int even = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, odd) + findKth(nums1, 0, nums2, 0, even)) * 0.5;
    }

    private double findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        //there are three base case
        if (left1 >= nums1.length) {
            //find all the remianing element in the nums2
            //-1 because left2 is the beginning index which we should include in the k
            //k is relative
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        //if there is only one element remaining
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        int mid1 = left1 + k / 2 - 1;
        int mid2 = left2 + k / 2 - 1;
        //if we can not reach the position of mid1 in nums1, we should deal with nums2
        int val1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int val2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        //move the left pointer with smaller mid value
        if (val1 < val2) {
            return findKth(nums1, mid1 + 1, nums2, left2, k - k / 2);
        } else {
            return findKth(nums1, left1, nums2, mid2 + 1, k - k / 2);
        }
    }
}