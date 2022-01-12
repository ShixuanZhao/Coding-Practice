class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //M1 two hashset
        // Set<Integer> set = new HashSet<>();
        // Set<Integer> intersection = new HashSet<>();
        // for (int num : nums1) {
        //     set.add(num);
        // }
        // for (int num : nums2) {
        //     if (set.contains(num)) {
        //         intersection.add(num);
        //     }
        // }
        // int i = 0;
        // int[] res = new int[intersection.size()];
        // for (int num : intersection) {
        //     res[i++] = num;
        // }
        // return res;
        
        //Sort both arrays, use two pointers
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}