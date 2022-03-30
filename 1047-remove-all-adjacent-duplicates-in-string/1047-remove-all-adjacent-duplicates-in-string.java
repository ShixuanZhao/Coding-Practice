class Solution {
    /*
    stack:ca
    s = "abbaca"
            i
    */
    public String removeDuplicates(String s) {
        // Deque<Character> stack = new ArrayDeque<>();
        // for (char c : s.toCharArray()) {
        //     if (stack.isEmpty() || c != stack.peekFirst()) {
        //         stack.offerFirst(c);
        //         continue;
        //     }
        //     while (!stack.isEmpty() && c == stack.peekFirst()) {
        //         stack.pollFirst();
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while (!stack.isEmpty()) {
        //     sb.insert(0, stack.pollFirst());
        // }
        // return sb.toString();
        
        //use two pointer to replace stack, the slow pointer point to the top ele in the stack,[0, slow] is what we want to return
        //this is wrong because we only need to remove two duplicated num other than all
        // int slow = -1;
        // int fast = 0;
        // char[] arr = s.toCharArray();
        // while (fast < s.length()) {
        //     if (slow == -1 || arr[slow] != arr[fast]) {
        //         arr[++slow] = arr[fast++];
        //     } else {
        //         slow--;
        //         fast++;
        //         //OR skip all duplicate
        //         //"aaaaaa" we should return "a" rather than ""
        //         // int temp = arr[fast];
        //         while (fast < arr.length && arr[fast] == temp) {
        //             fast++;
        //         }
        //     }
        // }
        // return new String(arr, 0, slow + 1);
        char[] arr = s.toCharArray();
        int slow = -1;
        int fast = 0;
        while (fast < arr.length) {
            // arr[++slow] = arr[fast++];
            // if (slow - 1 >= 0 && arr[slow] == arr[slow - 1]) {
            //     slow -= 2;
            // }
            if (slow < 0 || arr[slow] != arr[fast]) {
                arr[++slow] = arr[fast++];
            } else {
                slow--;
                fast++;
            }
        }
        return new String(arr, 0, slow + 1);
    }
}