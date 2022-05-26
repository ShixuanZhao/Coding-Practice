class Solution {
    //WRONG because when we remove, we want to remove one ele, but actually we remove all "aababcabc"
    // public int countGoodSubstrings(String s) {
    //     Set<Character> set = new HashSet<>();
    //     int n = s.length();
    //     set.add(s.charAt(0));
    //     set.add(s.charAt(1));
    //     int res = 0;
    //     for (int i = 2; i < n; i++) {
    //         set.add(s.charAt(i));
    //         if (set.size() == 3) {
    //             res++;
    //         }
    //         set.remove(s.charAt(i - 2));
    //     }
    //     return res;
    // }
    
   public int countGoodSubstrings(String s) {
       int[] map = new int[26];
       int n = s.length();
       int dup = 0;
       int res = 0;
       for (int i = 0; i < n; i++) {
           //must be ==2 not > 1, because multiple duplicate number, we will only add dup once
           if (++map[s.charAt(i) - 'a'] == 2) {
               dup++;
           }
           if (i < 2) {
               continue;
           }
           if (dup == 0) {
               res++;
           }
           if (--map[s.charAt(i - 2) - 'a'] == 1) {
               dup--;
           }
       }
       return res;
   }
}