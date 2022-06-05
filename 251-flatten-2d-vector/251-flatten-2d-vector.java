class Vector2D {
    int[][] vec;
    int indexList;
    int indexEle;
    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return vec[indexList][indexEle++];
    }
    
    public boolean hasNext() {
        while (indexList < vec.length && indexEle >= vec[indexList].length) {
            indexList++;
            indexEle = 0;
        }
        return indexList < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */