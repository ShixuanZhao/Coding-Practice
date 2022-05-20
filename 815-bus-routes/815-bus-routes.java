class Solution {
    /*
    The first part loop on routes and record stop to routes mapping in to_route.
The second part is general bfs. Take a stop from queue and find all connected route.
The hashset seen record all visited stops and we won't check a stop for twice.
We can also use a hashset to record all visited routes, or just clear a route after visit.
    */
    //return the number of transmit, some diff with traditional bfs
    //普通bfs是到终点的最短路径，这个是换成次数。所以从当前stop出发，所有可换乘的route的所有stop都是一层
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        //stop to routes 7->(0, 1) 1->(0)
        HashMap<Integer, HashSet<Integer>> to_routes = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!to_routes.containsKey(j))
                    to_routes.put(j, new HashSet<Integer>());
                to_routes.get(j).add(i);
            }
        }
        Queue<int[]> bfs = new ArrayDeque();
        //at first, we are at source, we do not need to take any bus
        bfs.offer(new int[] {source, 0});
        //the stop we have seen
        HashSet<Integer> seen = new HashSet<>();
        seen.add(source);
        boolean[] seen_routes = new boolean[n];
        while (!bfs.isEmpty()) {
            //bus is the number of bus we need to take
            int stop = bfs.peek()[0], bus = bfs.peek()[1];
            bfs.poll();
            if (stop == target) return bus;
            //从stop出发所有能换成的route
            //所有可换乘的route的所有stop都是一层，需要多乘一次车
            for (int i : to_routes.get(stop)) {
                if (seen_routes[i]) continue;
                //j is stop
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[] {j, bus + 1});
                    }
                }
                seen_routes[i] = true;
            }
        }
        return -1;
    }
}