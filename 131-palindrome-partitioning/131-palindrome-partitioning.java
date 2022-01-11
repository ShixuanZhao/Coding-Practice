class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> cur = new ArrayList<>();
        char[] array = s.toCharArray();
        partition(array, 0, res, cur);
        return res;
    }

    //dfs
    private void partition(char[] array, int index, List<List<String>> res, List<String> cur) {
        if (index == array.length) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = index; i < array.length; i++) {
            if (isPalidrome(array, index, i)) {
                 //the third parameter is length
                cur.add(new String(array, index, i - index + 1));
                partition(array, i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalidrome(char[] array, int i, int j) {
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}