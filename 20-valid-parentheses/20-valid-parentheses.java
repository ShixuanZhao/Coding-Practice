class Solution {
    /*
        { [ ) }
            i
        stack:} ] 
    */
    // public boolean isValid(String s) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             stack.offerFirst(')');
    //         } else if (c == '[') {
    //             stack.offerFirst(']');
    //         } else if (c == '{') {
    //             stack.offerFirst('}');
    //         } else {
    //             if (stack.isEmpty()) {
    //                 return false;
    //             } else {
    //                 if (stack.peekFirst() == c) {
    //                     stack.pollFirst();
    //                 } else {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     //find whether all the open paranthes has been matched
    //     return stack.isEmpty();
    // }
    
    //two pointers without using stack
    /*
    ([)]
       i
        j
    */
    public boolean isValid(String s) {
        //i:当前待匹配的元素的index，模拟栈顶元素(slow)
        char[] arr = s.toCharArray();
        //inclusive,没有任何元素没有被匹配上
        int i = -1;
        //fast 当前看的元素
        int j = 0;
        while (j < s.length()) {
            if (i == -1 || !isMatch(arr[i], arr[j])) {
                //没匹配上，替换成那个未匹配的元素
                arr[++i] = arr[j++];
            } else {
                i--;
                j++;
            }
        }
        return i == -1;
    }
    
    boolean isMatch(char c1, char c2){
        if(c1 == '(' && c2 == ')') return true;
        if(c1 == '[' && c2 == ']') return true;
        if(c1 == '{' && c2 == '}') return true;
        return false;
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