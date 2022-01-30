class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {                            
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    // group chars in T but not in S.
        }
        return sb.toString();
   }
    // public String customSortString(String order, String s) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : order.toCharArray()) {
    //         if (map.containsKey(c)) {
    //             for (int i = 0; i < map.get(c); i++) {
    //                 sb.append(c);
    //             }
    //             map.put(c, 0);
    //         }
    //     }
    //     //add non-common ele to the tail
    //     for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    //         if (entry.getValue() != 0) {
    //             for (int i = 0; i < entry.getValue(); i++) {
    //                 sb.append(entry.getKey());
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }
}