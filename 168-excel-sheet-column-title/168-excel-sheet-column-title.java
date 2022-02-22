class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        //26进制余数0-25转成'A'-> 0, 这样不会出现余数是26的情况
        for (int i = columnNumber; i != 0; i /= 26) {
            i--;
            int cur = i % 26;
            sb.append((char)(cur + 'A'));
        }
        return sb.reverse().toString();
    }
}