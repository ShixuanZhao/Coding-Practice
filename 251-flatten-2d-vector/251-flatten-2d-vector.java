class Vector2D {
    int indexList;
    int indexEle;
    int[][] vector;
    public Vector2D(int[][] vec) {
        indexList = 0;
        indexEle = 0;
        vector = vec;
    }
    
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return vector[indexList][indexEle++];
    }
    
    public boolean hasNext() {
        //must be while not if because some list can be empty. we need to keep moving index
        while (indexList < vector.length && indexEle >= vector[indexList].length) {
            indexList++;
            indexEle = 0;
        }
        return indexList < vector.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */