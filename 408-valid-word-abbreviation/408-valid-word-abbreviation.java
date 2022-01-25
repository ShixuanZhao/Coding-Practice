class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        //case1 abbr, cur is number 
        //case2 abbr, cur is letter
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            char temp = abbr.charAt(j);
            //skip the leading zero
            if (temp <= '0' || temp > '9') {
                return false;
            }
            int k = j;
            //extract the number
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            int sum = Integer.valueOf(abbr.substring(k, j));
            i += sum;
        }
        return i == word.length() && j == abbr.length();
    }
}