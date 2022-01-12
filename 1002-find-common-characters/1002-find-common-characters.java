class Solution {
    //find common letter in k array
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] dict = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            dict[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                cur[A[i].charAt(j) - 'a']++;
            }
            //update the common dict
            for (int j = 0; j < 26; j++) {
                if (cur[j] < dict[j]) {
                    dict[j] = cur[j];
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                res.add(Character.toString((char)(i + 'a')));
            }
        }
        return res;
    }
}