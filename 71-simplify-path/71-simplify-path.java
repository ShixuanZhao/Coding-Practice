class Solution {
    /*
        use stack to store the filename that we want to return
        stack:c  
        "", a, ., b.., .., c
        case1:skip when we meet "" || "."
        case2:pop when we meet ".."
        case3:push to stack when we meet filename
        
        /a/./b/../../c/
                  i
        iterate the ele in the stack
    */
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] name  = path.split("/");
        for (String s : name) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                stack.pollFirst();
            } else {
                stack.offerFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        //corner case
        //input:"/../"
        //we should return "/" other than ""
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            //no tailing '/'
            sb.insert(0, stack.pollFirst());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}