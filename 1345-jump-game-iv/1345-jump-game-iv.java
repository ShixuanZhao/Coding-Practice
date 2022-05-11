class Solution {
    //BFS, three cases for generating neighboors
    public int minJumps(int[] arr) {
        //use a map to record the all the index for the same value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(arr.length - 1);
        boolean[] visited = new boolean[arr.length];
        visited[arr.length - 1] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int i = q.poll();
                if (i == 0) {
                    return step;
                }
                if (i + 1 < arr.length && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }
                List<Integer> next = map.getOrDefault(arr[i], new ArrayList<>());
                for (int cur : next) {
                    if (!visited[cur]) {
                        visited[cur] = true;
                        q.offer(cur);
                    }
                }
                //it is important, eg:777777777712, we have duplicate 7
                next.clear();
            }
            step++;
        }
        return -1;
    }
}