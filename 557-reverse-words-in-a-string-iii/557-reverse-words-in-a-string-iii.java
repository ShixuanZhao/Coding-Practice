class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j + 1) != ' ') {
                    j++;
                }
                reverse(arr, i, j);
                j += 2;
                i = j;
            }
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] ca, int i, int j) {
       while (i < j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
            i++;
            j--;
        }
    }
}