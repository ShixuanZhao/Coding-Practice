class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //build the map<Manager, list of Employee>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i], new LinkedList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, headID, informTime);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int manager, int[] informTime) {
        int max = 0;
        //leaf node
        if (!map.containsKey(manager)) {
            return max;
        }
        for (int employee : map.get(manager)) {
            max = Math.max(max, dfs(map, employee, informTime));
        }
        return max + informTime[manager];
    }
}