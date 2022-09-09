class Solution {
    /*
    use a treemap, key is the time point, val is the change
    0  5 10   15 20  30
    1  1  -1  1  -1   -1
cnt:                  0
res:2
    */
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] cur : intervals) {
            map.put(cur[0], map.getOrDefault(cur[0], 0) + 1);
            map.put(cur[1], map.getOrDefault(cur[1], 0) - 1);
        }
        int res = 0;
        int cnt = 0;
        for (int cur : map.values()) {
            cnt += cur;
            res = Math.max(res, cnt);
        }
        return res;
    }
}