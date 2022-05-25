class Solution {
    //[0,left) is what we want to return
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        int n = chars.length;
        while (fast < n) {
            char temp = chars[fast];
            int cnt = 0;
            while (fast < n && chars[fast] == temp) {
                fast++;
                cnt++;
            }
            chars[slow++] = temp;
            if (cnt != 1) {
                for (char c : String.valueOf(cnt).toCharArray()) {
                    chars[slow++] = c;
                }
            }
        }
        return slow;
    }
}