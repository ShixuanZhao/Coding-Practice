class Solution {
    // public boolean backspaceCompare(String s, String t) {
    //     Deque<Character> stack1 = new ArrayDeque<>();
    //     Deque<Character> stack2 = new ArrayDeque<>();
    //     for (char c : s.toCharArray()) {
    //         if (Character.isLetter(c)) {
    //             stack1.offerFirst(c);
    //         } else {
    //             stack1.pollFirst();
    //         }
    //     }
    //     for (char c : t.toCharArray()) {
    //         if (Character.isLetter(c)) {
    //             stack2.offerFirst(c);
    //         } else {
    //             stack2.pollFirst();
    //         }
    //     }
    //     if (stack1.size() != stack2.size()) {
    //         return false;
    //     }
    //     while (!stack1.isEmpty()) {
    //         if (stack1.pollFirst() != stack2.pollFirst()) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
//     Can you do it in O(N) time and O(1) space?
// I believe you have one difficulty here:
// When we meet a char, we are not sure if it will be still there or be deleted.
// However, we can do a back string compare (just like the title of problem).
// If we do it backward, we meet a char and we can be sure this char won't be deleted.
// If we meet a '#', it tell us we need to skip next lowercase char.
// The idea is that, read next letter from end to start.
// If we meet #, we increase the number we need to step back, until back = 0
    //stack-> two pointer save the space
    
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sback = 0;
        int tback = 0;
        //backward
        //|| not &&
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sback++;
                    i--;
                } else if (sback > 0) {
                    sback--;
                    i--;
                } else {
                    break;
                }
            }
             //now i is the character that we can ensure not to be delete
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tback++;
                    j--;
                } else if (tback > 0) {
                    tback--;
                    j--;
                } else {
                    break;
                }
            }
            //compare i and j
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            //一个有一个没有
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    
}