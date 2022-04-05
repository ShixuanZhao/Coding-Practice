class Solution {
    public int leastInterval(char[] tasks, int n) {
        //char_map
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        //the last ele not need to wait for cool down
        int max_val = map[25] - 1;
        int idle_slots = max_val * n;
        for (int i = 24; i >= 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}