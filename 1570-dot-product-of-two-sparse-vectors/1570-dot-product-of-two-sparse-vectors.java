class SparseVector {
    //use a HashMap to record the ele that is not zero
    //key is index, val is val
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (this.map.size() < vec.map.size()) {
            return dotProduct(this, vec);
        } else {
            return dotProduct(vec, this);
        }
    }
    
    private int dotProduct(SparseVector small, SparseVector large) {
        int res = 0;
        for (int i : small.map.keySet()) {
            if (large.map.containsKey(i)) {
                res += small.map.get(i) * large.map.get(i);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);