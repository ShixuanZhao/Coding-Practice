class Solution {
    /*
    Imagine a bus moving forward, and imagine each char as a person yelling "I need to go that far!". 
If a newcomer yelled a further position, we extend our expected ending position to that position. 
Eventually, if we reached a position that satisfied everybody in the bus at the moment, we partition and clear the bus.

1 traverse the string record the last index of each char.
2 using pointer to record end of the current sub string.
    */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int[] lastPos = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end -start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}