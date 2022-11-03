class Solution {
    //backtracking combanation
    //hashmap to store the debt for each person,it is a directed map, use + - to represent debt
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }
        List<Integer> debt = new ArrayList<>();
        for (int val : map.values()) {
            debt.add(val);
        }
        return dfs(0, debt);
    }
    
    //the min ops to deal with the debt from start to last ele of list, before the start is what we have settle down.
    private int dfs(int start, List<Integer> list) {
        if (start == list.size()) {
            return 0;
        }   
        int cur = list.get(start);
        if (cur == 0) {
            return dfs(start + 1, list);
        }
        int minOps = Integer.MAX_VALUE;
        //try to settle the debt with i 
        for (int i = start + 1; i < list.size(); i++) {
            int next = list.get(i);
            //different sign means we can settle the debt
            if (next * cur < 0) {
                // if (next == -cur) {
                //     return dfs(start + 1, list) + 1;
                // }
                list.set(i, cur + next);
                minOps = Math.min(minOps, dfs(start + 1, list) + 1);
                list.set(i, next);
                if (cur + next == 0) {
                    break;
                }
            }
        }
        return minOps;
    }
}