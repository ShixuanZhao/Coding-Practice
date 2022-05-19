class SparseVector {
    /*
    brute force:TC: O(N) SC : O(1)  n == nums1.length == nums2.length
    hashmap to store the non-zero index and val:
    TC: O(n) for creating the Hash Map; O(L) for calculating the dot product.
    SC :O(L) for creating the Hash Map L is the num of non-zero ele
    
    */
    
    //use a HashMap to record the ele that is not zero
    //key is index, val is val
//     Map<Integer, Integer> map;
//     SparseVector(int[] nums) {
//         map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 map.put(i, nums[i]);
//             }
//         }
//     }
    
// 	// Return the dotProduct of two sparse vectors
//     public int dotProduct(SparseVector vec) {
//         if (this.map.size() < vec.map.size()) {
//             return dotProduct(this, vec);
//         } else {
//             return dotProduct(vec, this);
//         }
//     }
    
//     private int dotProduct(SparseVector small, SparseVector large) {
//         int res = 0;
//         for (int i : small.map.keySet()) {
//             if (large.map.containsKey(i)) {
//                 res += small.map.get(i) * large.map.get(i);
//             }
//         }
//         return res;
//     }
    
    //Value Pair Indexing
    class Pair {
        int key;
        int val;
        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    //record the pair which key is not zero
    List<Pair> list;
    // Time O(N), space O(L)
    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new Pair(i, nums[i]));
            }
        }
    }
    
    public int dotProduct(SparseVector vec) {
        if (this.list.size() < vec.list.size()) {
            return dotProduct(this, vec);
        } else {
            return dotProduct(vec, this);
        }
    }
    
    // Time O(min(L1, L2) * log(max(L1, L2))), space O(1)
    private int dotProduct(SparseVector small, SparseVector large) {
        int res = 0;
        for (Pair p : small.list) {
            if (search(large.list, p.key) != -1) {
                res += search(large.list, p.key) * p.val;
            } 
        }
        return res;
    }
    
    //Binary search
    //search the val in arraylist which index is t
    //if not found, return -1
    //对于每一个在size小的list里的数，在大的list里面做binary search
    private int search(List<Pair> list, int t) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).key == t) {
                return list.get(mid).val;
            } else if (list.get(mid).key < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);