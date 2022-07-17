class Solution {
    /*
        ab(a < b)the value change from b + a to b - a 
        we do sum repeadetly if we meet this edge case we - 2 * a
        M C M
          p c
      res:1000+100+1000-200=1900
      "MCMXCIV"
         i
       1000 + 100 - 200 
    */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        //char prev = ' ';
        //int res = 0;
        //或者从右往左遍历，这样能确定是加还是减
        // for (char c : s.toCharArray()) {
        //     res += map.get(c);
        //     if (prev != ' ' && map.get(c) > map.get(prev)) {
        //         res -= 2 * map.get(prev);
        //     }
        //     prev = c;
        // }
        // return res;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}