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
		clean(robot, 0, 0, 1, new HashSet<>());
	}

	private void clean(Robot robot, int x, int y, int curDirection, Set<String> cleaned) {
		robot.clean();
        //cleaned means visited
		cleaned.add(x + " " + y);

		for (int i = 0; i < 4; i++) {
			int nx = x + DIRS[curDirection][0];
			int ny = y + DIRS[curDirection][1];
			if (!cleaned.contains(nx + " " + ny) && robot.move()) {
				clean(robot, nx, ny, curDirection, cleaned);
				goBack(robot);
			}
			robot.turnRight();
			curDirection = (curDirection + 1) % 4;
		}

	}

	private void goBack(Robot robot) {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}
}