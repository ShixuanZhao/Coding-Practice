class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//   Let me try to explain the approach.
// This is just plain BFS but instead of using standard FIFO queue , we are using Max heap/ priority queue. This will ensure that we always pick up next node in queue with maximum smallest value. So queue will still have all possible values from a cell, but we only pick node with maximum value amongst them.
// Example Suppose from (0,0) position we have 2 options to go (3,4}. We will add both values in queue but 4 will be at top. Next we process 4 and suppose options from 4 are {1,5}
// We will add both the options, but cell with value 5 will be processed next( and not 3 as in normal FIFO queue). Going this way once you reach target, you are done as BFS approach finds best solution first.
  public int maximumMinimumPath(int[][] A) {
    int n = A.length;
    int m = A[0].length;
    boolean[][] visited = new boolean[n][m];
    
    // in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far, thus we reverse the ordering in the pq
    Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
    
    pq.offer(new int[]{0, 0, A[0][0]});
    
    // BFS
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int row = cell[0];
      int col = cell[1];
      
      if (row == n - 1 && col == m - 1) {
          //cell[2] is the min val in the path
        return cell[2];
      }
      
      visited[row][col] = true;
      
      for (int[] dir : directions) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];
        
        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]) continue;
        
        // we are keeping track of the min element that we have seen until now
        pq.offer(new int[]{nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
      }
    }
    return -1;
  }
}