class Solution {
    /*
        { [ ) }
            i
        stack:} ] 
    */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peekFirst() == c) {
                        stack.pollFirst();
                    } else {
                        return false;
                    }
                }
            }
        }
        //find whether all the open paranthes has been matched
        return stack.isEmpty();
    }
    
    /*
    WRONG!
    Open brackets must be closed by the same type of brackets.
    "([)]" can not pass
    */
    // public boolean isValid(String s) {
    //     int cnt1 = 0;
    //     int cnt2 = 0;
    //     int cnt3 = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             cnt1++;
    //         } else if (c == ')') {
    //             cnt1--;
    //         } else if (c == '[') {
    //             cnt2++;
    //         } else if (c == ']') {
    //             cnt2--;
    //         } else if (c == '{') {
    //             cnt3++;
    //         } else if (c == '}') {
    //             cnt3--;
    //         }
    //         if (cnt1 < 0 || cnt2 < 0 || cnt3 < 0) {
    //             return false;
    //         }
    //     }
    //     return cnt1 == 0 && cnt2 == 0 && cnt3 == 0;
    // }
}