/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
//     For example, {{-1, 0}, {0, 1}, {1, 0}, {0, -1}} are up. right, down, left clockwise.
// Why {-1, 0} is up?
// It is (row - 1, col + 0) up rather than (x - 1, y + 0).
      public static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};;

	public void cleanRoom(Robot robot) {
		dfs(robot, 0, 0, 0, new HashSet<String>());
	}

	private void dfs(Robot robot, int i, int j, int curDir, Set<String> visited) {
        robot.clean();
        visited.add(i + "," + j);
        for (int k = 0; k < 4; k++) {
            int nx = i + DIRS[curDir][0];
            int ny = j + DIRS[curDir][1];
            if (!visited.contains(nx + "," + ny) && robot.move()) {
                dfs(robot, nx, ny, curDir, visited);
                goback(robot);
            }
            robot.turnRight();
            //change dir
            curDir = (curDir + 1) % 4;
        }
    }
    
    private void goback(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}