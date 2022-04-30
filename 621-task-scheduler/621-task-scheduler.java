class Solution {
    /*
    ["A","A","A","B","B","B"], n = 2
    [3,3,0,0....]
    [0,0,...3,3]
    idle = 2 * 2 = 4
    idle = 4 - 2 = 2
    2 + 6 = 8
    */
    public int leastInterval(char[] tasks, int n) {
        //char_map
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        //the last ele not need to wait for cool down
        int max_val = map[25] - 1;
        //after fill out the most freq ele, suppose all other are idle
        int idle_slots = max_val * n;
        //fill out the idles 
        for (int i = 24; i >= 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        //remaining idles are idles that can not be filled up
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}