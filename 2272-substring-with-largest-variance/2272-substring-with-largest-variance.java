class Solution {
    public int largestVariance(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        //suppose freq: c1 > c2 
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                if (c1 == c2) {
                    continue;
                }
                int f1 = 0;
                int f2 = 0;
                int f2Cnt = map.get(c2);
                for (int i = 0; i < s.length(); i++) {
                    char cur = s.charAt(i);
                    if (cur == c1) {
                        f1++;
                    }
                    if (cur == c2) {
                        f2++;
                        f2Cnt--;
                    }
                    if (f1 > 0 && f2 > 0 && f1 > f2) {
                        res = Math.max(res, f1 - f2);
                    }
                    if (f1 < f2 && f2Cnt > 0) {
                        f1 = 0;
                        f2 = 0;
                    }
                }
            }
        }
        return res;
    }
}