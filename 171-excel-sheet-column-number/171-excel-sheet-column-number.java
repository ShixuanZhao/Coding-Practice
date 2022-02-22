class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            //26进制
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}