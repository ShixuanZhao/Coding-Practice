class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();
        // add all gates to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i,j});
                }
            }
        }
        // update distance from gates
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] dir: dirs) {
                int X = curPos[0] + dir[0];
                int Y = curPos[1] + dir[1];
                //rooms[X][Y] != Integer.MAX_VALUE
                //means we have visited the empty room
                //bfs will ensure the shortest distance when we first time visit
                //a empty room
                if (X<0 || Y <0 || X >= m || Y >= n || rooms[X][Y] != Integer.MAX_VALUE || rooms[X][Y] == -1) continue;
                rooms[X][Y] = rooms[curPos[0]][curPos[1]]+1;
                queue.offer(new int[] {X, Y});
            }
        }
    }
}