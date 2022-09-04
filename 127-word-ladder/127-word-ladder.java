class Solution {
    /*
    BFS
    h it  h i t
    ait   h a  t
    bit
    for each letter, try to change it to another letter from a-z, check whether it is in wordSet
    if yes, generate
    until we find the endWord
    
    time complexity is O(N*M), where N is size of the dictionary and M is length of the word.
  not consider string equals
Details:

To generate neighbors - O(26 * M)
To check if the word exists in dict - O(1). This is a reason why it is better to put all words to the Set. Note, that the original version of this problem uses List<String> wordList. It is a bit confusing since author changed the signature to Set<String> dict.
To generate a tree and traverse the tree via BFS - O(N)
So, the result is O(26 * M * 1 * N) -> O(M * N)
S= O(n) bfs tree
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return level + 1;
                }
                List<String> neiList = getNei(cur, wordSet);
                for (String nei : neiList) {
                    if (visited.add(nei)) {
                        q.offer(nei);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    private List<String> getNei(String cur, Set<String> set) {
        List<String> res = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            char temp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == temp) {
                    continue;
                }
                arr[i] = c;
                String newWord = new String(arr);
                if (set.contains(newWord)) {
                    res.add(newWord);
                }
            }
            arr[i] = temp;
        }
        return res;
    }
}