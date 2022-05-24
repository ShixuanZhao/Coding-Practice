class Solution {
    /*
    not right
    M[i]:min step from i to 1
    M[i] = M[i / 2] + 1   i is even
    M[i] =  ??? when i is odd
    */
    // Map<Integer, Integer> map = new HashMap<>();
    // public int integerReplacement(int n) {
    //     if (n == 1) {
    //         return 0;
    //     } 
    //     if (n == Integer.MAX_VALUE) {
    //         return 32;
    //     }
    //     if (map.containsKey(n)) {
    //         return map.get(n);
    //     }
    //     if (n % 2 == 0) {
    //         int res = 1 + integerReplacement(n / 2);
    //         map.put(n, res);
    //         return res;
    //     } else {
    //         int res = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
    //         map.put(n, res);
    //         return res;
    //     }
    // }
    
    //can also use bfs
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } 
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 1) {
                    return level;
                }
                if (cur % 2 == 0 && set.add(cur / 2)) {
                    q.offer(cur / 2);
                }
                if (cur % 2 != 0 && set.add(cur + 1)) {
                    q.offer(cur + 1);
                }
                if (cur % 2 != 0 && set.add(cur - 1)) {
                    q.offer(cur - 1);
                }
            }
            level++;
        }
        return -1;
    }
}