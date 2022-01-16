class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         //不定长的sw，可行解到最优解
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return res;
        }
        int slow = 0;
        int fast = 0;
        int match = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        //create the freqMap in which the elements need to be matched
        for (char c : p.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        while (fast < s.length()) {
            char c = s.charAt(fast);
            Integer count = freqMap.get(c);
            if (count != null) {
                freqMap.put(c, --count);
                if (count == 0) {
                    match++;
                }
            }
            
            fast++;
            //match: has match
            while (match == freqMap.size()) {
                if (fast - slow == p.length()) {
                    res.add(slow);
                }
                c = s.charAt(slow);
                count = freqMap.get(c);
                if (count != null) {
                    // freqMap.put(c, ++count);
                    // if (count == 1) {
                    //     match--;
                    // }
                    if (count == 0) {
                        match--;
                    }
                    freqMap.put(c, ++count);
                }
                slow++;
            }
        }
        return res;
    }
}