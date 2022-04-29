class Solution {
    /*
    M1: sort and compare O(nlogn) O(n)
    M2;one hashmap store ele and freq in s
    boss sosb
    b:1
    s:1
    
    check whether the size == 0
    */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }
}