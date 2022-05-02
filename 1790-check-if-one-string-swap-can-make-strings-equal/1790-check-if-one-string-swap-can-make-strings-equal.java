class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Integer> diff = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.size() == 0 || (diff.size() == 2 && s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
        s1.charAt(diff.get(1)) == s2.charAt(diff.get(0)))) {
            return true;
        }
        return false;
    }
}