class Solution {
    public String alienOrder(String[] words) {
        // //step 0: create data structures
        // Map<Character, List<Character>> adList = new HashMap<>();
        // Map<Character, Integer> indegree = new HashMap<>();
        // for (String s : words) {
        //     for (char c : s.toCharArray()) {
        //         indegree.put(c, 0);
        //         adList.put(c, new LinkedList<Character>());
        //     }
        // }
        // //compare two String and construct the adjancency list and indegreeMap
        // for (int i = 1; i < words.length; i++) {
        //     String prevString = words[i - 1];
        //     String curString = words[i];
        //     //if prevString is ab, and the curString is a. This case is invalid
        //     if (prevString.length() > curString.length() && prevString.startsWith(curString)) {
        //         return "";
        //     }
        //     //find the first different char, and remaining chars in two String can be ignore\
        //     for (int j = 0; j < prevString.length() && j < curString.length(); j++) {
        //         char prevChar = prevString.charAt(j);
        //         char curChar = curString.charAt(j);
        //         if (prevChar != curChar) {
        //             adList.get(prevChar).add(curChar);
        //             indegree.put(curChar, indegree.get(curChar) + 1);
        //             break;
        //         }
        //     }
        // }
        // //BFS
        //有向图的拓扑排序（需要indegree）
        // //find the char whose indegree is 0, put the char into queue
        // Queue<Character> queue = new LinkedList<>();
        // for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
        //     if (entry.getValue().equals(0)) {
        //         queue.offer(entry.getKey());
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while (!queue.isEmpty()) {
        //     char cur = queue.poll();
        //     sb.append(cur);
        //     for (Character nei : adList.get(cur)) {
        //         int num = indegree.get(nei);
        //         indegree.put(nei, --num);
        //         if (num == 0) {
        //             queue.offer(nei);
        //         }
        //     }
        // }
        // //check out whether the solution is valid because it is possible to form a cycle  a->b b-> a
        // if (sb.length() != indegree.size()) {
        //     return "";
        // }
        // return sb.toString();
        
        
        //Solution2:DFS.DFS判断一个图里是否有环。用visited[i] = 1表示当前正在遍历的节点。如果在遍历当前path的过程中发现又回到了这个节点，那就表示有环，否则最后遍历完毕，把节点设为2.由于DFS一直走到底才返回，所以简历一个反向邻接表，这样可以直接输出当前路径
         //step 0: create data structures
        Map<Character, List<Character>> adList = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                adList.put(c, new LinkedList<Character>());
            }
        }
        //compare two String and construct the adjancency list and indegreeMap
        for (int i = 1; i < words.length; i++) {
            String prevString = words[i - 1];
            String curString = words[i];
            //if prevString is ab, and the curString is a. This case is invalid
            if (prevString.length() > curString.length() && prevString.startsWith(curString)) {
                return "";
            }
            //find the first different char, and remaining chars in two String can be ignore\
            for (int j = 0; j < prevString.length() && j < curString.length(); j++) {
                char prevChar = prevString.charAt(j);
                char curChar = curString.charAt(j);
                if (prevChar != curChar) {
                    //note that this a reversed List, normally a < b is a->b, but here we have b->a
                    adList.get(curChar).add(prevChar);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //DFS to build up the output list
        for (Character c : adList.keySet()) {
            if (hasCycle(c, adList, visited, sb)) {
                return "";
            }
        }
         if (sb.length() != adList.size()) {
            return "";
        }
        return sb.toString();  
    }
    
    //return true if cycle detected
    private boolean hasCycle(Character c, Map<Character, List<Character>> adList, Map<Character, Integer> visited, StringBuilder sb) {
        if (visited.containsKey(c)) {
            return visited.get(c) == 1; //is this node is 1, a cycle is detected
        }
        visited.put(c, 1);
        for (Character next : adList.get(c)) {
            if (hasCycle(next, adList, visited, sb)) {
                return true;
            }
        }
        visited.put(c, 2);
        sb.append(c);
        return false;
    }
}