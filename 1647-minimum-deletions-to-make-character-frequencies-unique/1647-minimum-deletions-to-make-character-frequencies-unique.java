class Solution {
    /*
    a b c
    3 2 1
    used:3 2
    res:2
    use a hashset to record the used freq
    Greedy works since we can only delete characters (we cannot add or replace characters).

So, count each character first. For each 26 characters, check if it's count is already used. 
If so, delete characters until you find unused count, or reach zero.
    */
    public int minDeletions(String s) {
        int cnt[] = new int[26];
        int res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0 && !used.add(cnt[i])) {
                cnt[i]--;
                res++;
            }
        }
        return res;
    }
}