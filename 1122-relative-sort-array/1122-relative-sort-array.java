class Solution {
    /*
            Time: O(NlogN)
            Space: O(N)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[m];
        //ele in arr1, and freq
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int num : arr2) {
            if (map.containsKey(num)) {
                for (int i = 0; i < map.get(num); i++) {
                    res[index++] = num;
                }
            }
            map.remove(num);
        }
        for (int num : map.keySet()) {
            for (int i = 0; i < map.get(num); i++) {
                res[index++] = num;
            }
        }
        return res;
    }
}