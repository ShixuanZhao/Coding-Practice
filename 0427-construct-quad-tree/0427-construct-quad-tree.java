// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

    
//     public Node() {
//         this.val = false;
//         this.isLeaf = false;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;
//         this.bottomRight = bottomRight;
//     }
// };


class Solution {
     public Node construct(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        return construct(grid, left, right, up, down);
     }
    
    //overload
    public Node construct(int[][] grid, int left, int right, int up, int down) {
        Node node = new Node();
        if (isSame(grid, left, right, up, down)) {
            node.isLeaf = true;
            node.val = grid[up][left] == 1;
            return node;
        } else {
            int row_mid = up + (down - up) / 2;
            int col_mid = left + (right - left) / 2;
            node.isLeaf = false;
            node.topLeft = construct(grid, left, col_mid, up, row_mid);
            node.topRight = construct(grid, col_mid + 1, right, up, row_mid);
            node.bottomLeft = construct(grid, left, col_mid, row_mid + 1, down);
            node.bottomRight = construct(grid, col_mid + 1, right, row_mid + 1, down);
            return node;
        }
    }
    
    private boolean isSame(int[][] grid, int left, int right, int up, int down) {
        int val = -1;
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (val == -1) {
                    val = grid[i][j];
                } else if (val != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}