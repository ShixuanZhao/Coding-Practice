class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //distinct的理解：aba distinct number是2,2个a只能算一个就是问有几个不一样的letter
        //map: key is distinct character, value 是出现的次数，所以key的size直接和k比较久可以
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
        
        
    }
}