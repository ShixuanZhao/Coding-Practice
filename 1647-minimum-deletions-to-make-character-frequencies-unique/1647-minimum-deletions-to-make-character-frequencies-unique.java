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
        int[] freq = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && set.contains(freq[i])) {
                freq[i]--;
                res++;
            }
            set.add(freq[i]);
        }
        return res;
    }
}