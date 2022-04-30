class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    
    private void dfs(List<List<Integer>> rooms, int i, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        visited.add(i);
        for (int next : rooms.get(i)) {
            dfs(rooms, next, visited);
        }
    }
}