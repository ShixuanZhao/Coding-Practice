class SparseVector {
    //index to value
    //We only need to store the values > 0, as we dont need to waste computing on calculating for all 0 valued indexes. We are also storing the distinct index-value pairs in a map.
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
        // We want to iterate through the smaller map.
        if (vec.map.size() < this.map.size()) {
            return vec.dotProduct(this);
        }
        int res = 0;
        for (int curIndex : this.map.keySet()) {
            if (vec.map.containsKey(curIndex)) {
                res += this.map.get(curIndex) * vec.map.get(curIndex);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);