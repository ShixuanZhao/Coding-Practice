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
        String[] data = path.split("/");
        for (String s : data) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            } else {
                //filename
                stack.offerFirst(s);
            }
        }
        //corner case
        //input:"/../"
        //we should return "/" other than ""
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        /*
        "/home/app/"
        "/home/app"
        stack:home, app
        app/home/ reverse not right because file name is also be reversed
        */
        while (!stack.isEmpty()) {
            //no tailing '/'
            sb.insert(0, stack.pollFirst());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}