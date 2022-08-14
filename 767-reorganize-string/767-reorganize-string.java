class Solution {
    /*
    count letter appearance and store in hash[i]
    find the letter with largest occurence.
    put the letter into even index numbe (0, 2, 4 ...) char array
    put the rest into the array
    
    We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
In this way, we can make sure there is always a gap between the same characters

Consider this example: "aaabbbcdd", we will construct the string in this way:

a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
a b a c a _ b _ b // fill in "c" at position 3
a b a c a d b d b // fill in "d" at position 5, 7
    */
    // public String reorganizeString(String s) {
    //     int[] hash = new int[26];
    //     //construct hash array
    //     for (char c : s.toCharArray()) {
    //         hash[c - 'a']++;
    //     }
    //     //find the most letter and its freq
    //     char letter = 'a';
    //     int cnt = 0;
    //     for (int i = 0; i < 26; i++) {
    //         if (hash[i] > cnt) {
    //             letter = (char)(i + 'a');
    //             cnt = hash[i];
    //         }
    //     }
    //     int n = s.length();
    //     if (cnt > (n + 1) / 2) {
    //         return "";
    //     }
    //     char[] arr = new char[n];
    //     //put the letter into even index numbe (0, 2, 4 ...)
    //     int index = 0;
    //     while (hash[letter - 'a'] > 0) {
    //         arr[index] = letter;
    //         index += 2;
    //         hash[letter - 'a']--;
    //     }
    //     //put the rest into the array
    //     for (int i = 0; i < 26; i++) {
    //         while (hash[i] > 0) {
    //             if (index >= n) {
    //                 index = 1;
    //             }
    //             arr[index] = (char)(i + 'a');
    //             index += 2;
    //             hash[i]--;
    //         }
    //     }
    //     return new String(arr);
    // }
    
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //freq from large to small
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));
        for (char c : map.keySet()) {
            pq.add(new Point(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Point p1 = pq.poll();
            Point p2 = pq.poll();
            sb.append(p1.c).append(p2.c);
            if (--p1.freq > 0) {
                pq.offer(p1);
            }
            if (--p2.freq > 0) {
                pq.offer(p2);
            }
        }
        if (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }
        return sb.length() < s.length() ? "" : sb.toString();
    }
    
    class Point {
        char c;
        int freq;
        public Point(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}