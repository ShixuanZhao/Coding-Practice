class Solution {
    /*
    M1: sort and compare O(nlogn) O(n)
    M2;one hashmap store ele and freq in s
    boss sosb
    b:1
    s:1
    
    check whether the size == 0
    clarification: whether there is only letter in the string
    if there are " ", we cannot use int[]
    */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //traverse s
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        //traverse t
        for (int i = 0; i < t.length(); i++) {
            int cnt = --freq[t.charAt(i) - 'a'];
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }
    // public boolean isAnagram(String s, String t) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for (char c : t.toCharArray()) {
    //         if (!map.containsKey(c)) {
    //             return false;
    //         } else {
    //             map.put(c, map.get(c) - 1);
    //             if (map.get(c) == 0) {
    //                 map.remove(c);
    //             }
    //         }
    //     }
    //     return map.size() == 0;
    // }
}