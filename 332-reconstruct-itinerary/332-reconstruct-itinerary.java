class Solution {
	// The DFS method is actually trying to find the end first and the problem guarantees at least one valid itinerary exists, 
	// so there is only one end when the start is fixed as JFK. The end is the node with more ingress than egress,
	// or it is JFK when there is no node with more ingress than egress. 
	// The dfs method stops when it reaches the end and start retrieving backward and 
	// keep inserting the node at the beginning of the path.
	// Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. 
	// In this way, we always visit the smallest possible neighbor first in our trip.
    Map<String, PriorityQueue<String>> flights;
    //声明类型一定要是LinkedList才能用addFirst()
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return path;
    }
    
    private void dfs(String departure) {
        PriorityQueue<String> nei = flights.get(departure);
        //post order travesal, first find a valid（遍历所有的边） end
        while (nei != null && !nei.isEmpty()) {
            //访问过的边删除，避免重复访问这条边
            dfs(nei.poll());
        }
        //back-tracking
        path.addFirst(departure);
    }
}