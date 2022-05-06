class Solution {
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
            sb.insert(0, stack.pollFirst());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}