class Solution {
    /*
    "abcxyz123abc", words = ["abc","123"]
    */
    public String addBoldTag(String s, String[] words) {
        //use a boolean[] to mark the char that need to be bold
        int n = s.length();
        boolean[] bold = new boolean[n];
        //the start index of word in s
        for (String word : words) {
            int start = 0;
            while (s.indexOf(word, start) != -1) {
                int index = s.indexOf(word, start);
                int end = index + word.length();
                for (int i = index; i < end; i++) {
                    bold[i] = true;
                }
                //aaaa find aaa, the letter can be used
                //aaa
                // aaa
                start = index + 1;
            }
        }
        //bold like this[111000111]
        //add <b> and </b>
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            //add open tag before the char in s, [00<b>1...]
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            //add close tag after the cur char in s [11</b>0...]
            if (bold[i] && (i == n - 1 || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}