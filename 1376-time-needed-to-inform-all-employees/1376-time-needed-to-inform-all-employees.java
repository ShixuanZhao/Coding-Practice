class Solution {
    //top-down easy to understand
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//         //build the map<Manager, list of Employee>
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < manager.length; i++) {
//             map.putIfAbsent(manager[i], new LinkedList<>());
//             map.get(manager[i]).add(i);
//         }
//         return dfs(map, headID, informTime);
//     }
    
//     private int dfs(Map<Integer, List<Integer>> map, int manager, int[] informTime) {
//         int max = 0;
//         //leaf node
//         if (!map.containsKey(manager)) {
//             return max;
//         }
//         for (int employee : map.get(manager)) {
//             max = Math.max(max, dfs(map, employee, informTime));
//         }
//         return max + informTime[manager];
//     }
    
    //bottom-up 
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }
    
    //the time need for the employee i be informed
    //informTime: the time need for the employee i be informed from the root for each node
    private int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            //mark this node's manager as -1. Why? Because you don't want to ask for information again once the information has reached you.
            manager[i] = -1;
        }
        return informTime[i];
    }
}