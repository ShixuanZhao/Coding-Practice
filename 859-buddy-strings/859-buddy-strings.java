class Solution {
    /*
    must swap for one time
    If A.length() != B.length(): no possible swap
If A == B, we need swap two same characters. Check is duplicated char in A.
In other cases, we find index for A[i] != B[i]. There should be only 2 diffs and it's our one swap.
    */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        //aa aa return true
        //ab ab return false
        if (s.equals(goal)) {
            //store unique char
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            if (set.size() < s.length()) {
                //have unique char
                //it is ok we just need to swap the same two char
                return true;
            } else {
                //all char are different
                return false;
            }
        }
        //record all the different index
        List<Integer> diff = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && goal.charAt(diff.get(0)) == s.charAt(diff.get(1))) {
            return true;
        } else {
            return false;
        }
    }
}