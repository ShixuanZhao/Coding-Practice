class Solution {
    /*
        ab(a < b)the value change from b + a to b - a 
        we do sum repeadetly if we meet this edge case we - 2 * a
        M C M
          p c
      res:1000+100+1000-200=1900
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
        char prev = ' ';
        int res = 0;
        for (char c : s.toCharArray()) {
            res += map.get(c);
            //ab (a < b) we make minus
            if (prev != ' ' && map.get(prev) < map.get(c)) {
                res -= 2 * map.get(prev);
            }
            prev = c;
        }
        return res;
    }
}