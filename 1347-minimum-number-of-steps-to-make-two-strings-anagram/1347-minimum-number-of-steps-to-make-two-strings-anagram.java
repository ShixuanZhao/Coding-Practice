class Solution {
    /*
    需要注意的是不要double count
    s = bab", t = "aba"
    1.scan s, record the letter and its freq
    a:0 b:1
    2.scan s, 
    */
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            //compute the occurence in s
            cnt[s.charAt(i) - 'a']++;
            //compute the diff between s and t
            cnt[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int count : cnt) {
            //需要注意的是不要double count
            if (count > 0) {
                res += count;
            }
        }
        return res;
    }
}