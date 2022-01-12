class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //M1 two hashset
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        int i = 0;
        int[] res = new int[intersection.size()];
        for (int num : intersection) {
            res[i++] = num;
        }
        return res;
    }
}