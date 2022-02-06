class Solution {
    //wrong
//     public boolean verifyPreorder(int[] preorder) {
//         boolean[] res = new boolean[] {true};
//         int[] index = new int[1];
//         dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, res, index);
//         return res[0];
//     }
    
//     private void dfs(int[] preorder, int low, int high, boolean[] res, int[] index) {
//         if (index[0] == preorder.length) {
//             return;
//         }
//         if (preorder[index[0]] < low || preorder[index[0]] > high) {
//             res[0] = false;
//             return;
//         }
//         int val = preorder[index[0]];
//         index[0]++;
//         dfs(preorder, low, val, res, index);
//         dfs(preorder, val, high, res, index);
//     }
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
//     Since given preorder sequence, the first element is always the root. 
// Partition the array by the key of root, find the index of the first number greater than it.
    private boolean helper(int[] preorder, int left, int right, int min, int max) {
        if (left > right) {
            return true;
        }
        int root = preorder[left];
        if (root < min || root > max) {
            return false;
        }
        int rightIndex = left + 1;
        while (rightIndex <= right && preorder[rightIndex] <= root) {
            rightIndex++;
        }
        return helper(preorder, left + 1, rightIndex - 1, min, root) && helper(preorder, rightIndex, right, root, max);
    }
}