class Solution {
    /*
    1.append the common letter according to the order in order string
    2append the uncommon letter at tail
    order = "cba", s = "abcd"
    */
    public String customSortString(String order, String s) {
        //letter and freq in s
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}