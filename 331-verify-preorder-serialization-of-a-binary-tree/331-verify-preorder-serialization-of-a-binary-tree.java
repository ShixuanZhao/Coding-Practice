class Solution {
    /*
    Then I think it is better to consider the problems from the relation of edges and nodes:
1. For a full binary tree, # of node = # of edges + 1, thus if we manually add an edge to the root, then the # of edges = the # of nodes;
2. For a node, it consumes one edge and produces 2 new edges(if not null)
    */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int edges = 1;
        for(int i = 0; i < nodes.length; i++){
            edges--; // consume one edge
            if(edges < 0) return false; // to prevent the case: [#,](https://leetcode.com/problems/powx-n) a, ...
            if(!nodes[i].equals("#")){
                edges += 2; // generate 2 edges
            }
        }
        return edges == 0;
    }
}