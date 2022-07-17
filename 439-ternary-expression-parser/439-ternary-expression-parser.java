class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        char[] arr = expression.toCharArray();
        return dfs(arr, 0, expression.length() - 1) + "";
    }
    
    private char dfs(char[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        //find the most outer layer ? :
        //the position of matched :
        int i = left;
        int cnt = 0;
        for (;i < right; i++) {
            if (arr[i] == '?') {
                cnt++;
            } else if (arr[i] == ':') {
                cnt--;
                if (cnt == 0) {
                    break;
                }
            }
        }
        return arr[left] == 'T' ? dfs(arr, left + 2, i - 1) : dfs(arr, i + 1, right);
    }
}