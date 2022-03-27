class Solution {
    //graph, check one connected component
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        dfs(0, rooms, set);
        return set.size() == rooms.size();
    }
    
    //dfs from the room 0, add all the connected node to set
    private void dfs(int start, List<List<Integer>> rooms, Set<Integer> set) {
        set.add(start);
        for (int nei : rooms.get(start)) {
            if (!set.contains(nei)) {
                dfs(nei, rooms, set);
            }
        }
    }
}