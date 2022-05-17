class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, res);
        return res;
    }
    
    private void dfs(char[] arr, int index, List<String> res) {
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }
        if (Character.isDigit(arr[index])) {
            dfs(arr, index + 1, res);
            return;
        }
        arr[index] = Character.toLowerCase(arr[index]);
        dfs(arr, index + 1, res);
        arr[index] = Character.toUpperCase(arr[index]);
        dfs(arr, index + 1, res);
    }
}