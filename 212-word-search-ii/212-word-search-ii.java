class Solution {
    //return list should be unique word
    //build a trie given the words[]
    //for each position as start point, search in the trie
    public List<String> findWords(char[][] board, String[] words){
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Trie trie = new Trie();
        trie.build(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, res);
            }
        }
        return res;
    }
    
    //Trie.TrieNode
    //T = O(M*4^L) M is the number of cells in the board and L is the maximum length of words.
    //Space Complexity: O(N), where N is the total number of letters in the dictionary.
    private void dfs(char[][] board, boolean[][] visited, int x, int y, Trie.TrieNode root, List<String> res) { 
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || root.children[board[x][y] - 'a'] == null) {
            return;
        }
        visited[x][y] = true;
        root = root.children[board[x][y] - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        dfs(board, visited, x - 1, y, root, res);
        dfs(board, visited, x + 1, y, root, res);
        dfs(board, visited, x, y - 1, root, res);
        dfs(board, visited, x, y + 1, root, res);
        visited[x][y] = false;
    }
    
    class Trie {
        class TrieNode {
            //store the whole word in the last letter of the word
            //使用ending word模板
            String word;
            TrieNode[] children;
            public TrieNode() {
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        
        //words.length * max(word)
        public void build(String[] words) {
            for (String word : words) {
                //this position
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.word = word;
            }
        }
    }
}

// class Solution {
//     Set<String> res = new HashSet<>(); //因为可能会有重复的
//     public List<String> findWords(char[][] board, String[] words) {
//         //从每一个位置暴力展开向4个方向，同时用Trie的searchPrefix来做剪枝，stop earlier
//         int m = board.length;
//         int n = board[0].length;
//         Trie trie = new Trie();
//         //construct trie(letter dictionary using word[])
//         for (String word : words) {
//             trie.insert(word);
//         }
//         boolean[][] visited = new boolean[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dfs(board, visited, "", i, j, trie);
//             }
//         }
//         return new ArrayList<String>(res);
//     }
    
//     private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
//         if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
//             return;
//         }
//         if (visited[x][y]) {
//             return;
//         }
//         str += board[x][y];
//         if (!trie.startsWith(str)) {
//             return;
//         }
//         if (trie.search(str)) {
//             res.add(str);
//         }
//         visited[x][y] = true;
//         dfs(board, visited, str, x - 1, y, trie);
//         dfs(board, visited, str, x + 1, y, trie);
//         dfs(board, visited, str, x, y - 1, trie);
//         dfs(board, visited, str, x, y + 1, trie);
//         visited[x][y] = false;
//     }
    
//     class Trie {
//     TrieNode root;
    
//     public Trie() {
//         root = new TrieNode();    
//     }
    
//     public void insert(String word) {
//         TrieNode node = root;
//         for (char c : word.toCharArray()) {
//             if (node.children[c - 'a'] == null) {
//                 node.children[c - 'a'] = new TrieNode();
//             }
//             node = node.children[c - 'a'];
//         }
//         node.isWord = true;
//     }
    
//     public boolean search(String word) {
//         TrieNode node = root;
//         for (char c : word.toCharArray()) {
//             if (node.children[c - 'a'] == null) {
//                 return false;
//             }
//             node = node.children[c - 'a'];
//         }
//         return node.isWord;
//     }
    
//     public boolean startsWith(String prefix) {
//         TrieNode node = root;
//         for (char c : prefix.toCharArray()) {
//             if (node.children[c - 'a'] == null) {
//                 return false;
//             }
//             node = node.children[c - 'a'];
//         }
//         return true;
//     }
    
//     class TrieNode {
//         TrieNode[] children;
//         boolean isWord;
        
//         public TrieNode() {
//             children = new TrieNode[26];
//         }
//     }
// }
// }