class Solution {
    /*
    "abcxyz123abc", words = ["abc","123"]
    */
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] bold = new boolean[n];
        for (String word : words) {
            int start = 0;
            while (s.indexOf(word, start) != -1) {
                int index = s.indexOf(word, start);
                //not include
                int end = index + word.length();
                for (int i = index; i < end; i++) {
                    bold[i] = true;
                }
                start = index + 1;
            }
        }
        //[11100110]
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i] && (i == n - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}