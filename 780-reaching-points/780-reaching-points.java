class Solution {
    /*
    sx = 1, sy = 1, tx = 3, ty = 5
    (3, 5) (3, 2) (1, 2) (1, 1)
    	 It looks like a tree, if you know one node, 
	 it's always easy to get the root because you have exact one way to get the parent node.
    */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty)
            if (tx < ty) ty %= tx;
            else tx %= ty;
        //check if we reduce target points to (x, y+kx) or (x+ky, y)
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
               sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
    
    // TLE
    // public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    //     while (sx < tx || sy < ty) {
    //         if (tx == ty) {
    //             break;
    //         }
    //         if (tx > ty) {
    //             tx -= ty;
    //         } else if (tx < ty){
    //             ty -= tx;
    //         }
    //     }
    //compare root:(tx, ty) with (sx, sy)
    //     return sx == tx && sy == ty;
    // }
    
    //M3:from start to end BFS
}