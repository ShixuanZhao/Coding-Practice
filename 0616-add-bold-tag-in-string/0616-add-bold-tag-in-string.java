class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] mark = new boolean[n];
        for (String word : words) {
            int start = 0;
            while (s.indexOf(word, start) != -1) {
                int index = s.indexOf(word, start);
                int end = index + word.length();
                for (int i = index; i < end; i++) {
                    mark[i] = true;
                }
                start = start + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (mark[i] && (i == 0 || !mark[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (mark[i] && (i == n - 1 || !mark[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}