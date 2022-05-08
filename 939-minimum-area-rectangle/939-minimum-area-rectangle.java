class Solution {
    // HashMap, since two diagonal points uniquely define a rectangle, just use 2-fold loops and try find other two points in the HashMap. To do that in O(1) time, we can either organize y-coordinates by x, or just use a Set of pairs.  Time O(N^2), space O(N)
    public int minAreaRect(int[][] points) {
        //key is the x, value is a set of y with the same x
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int res = Integer.MAX_VALUE;
        //enumerate two points as diagonal points
        for (int[] d1 : points) {
            for (int[] d2 : points) {
                if (d1[0] == d2[0] || d1[1] == d2[1]) {
                    continue;
                }
                if (map.get(d1[0]).contains(d2[1]) && map.get(d2[0]).contains(d1[1])) {
                    res = Math.min(res, Math.abs(d1[0] - d2[0]) * Math.abs(d1[1] - d2[1]));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}