class Solution {
    public int[] findErrorNums(int[] nums) {
//         这个问题的特点是，每个元素和数组索引有一定的对应关系。

// 我们现在自己改造下问题，暂且将 nums 中的元素变为 [0..N-1]，这样每个元素就和一个数组索引完全对应了，这样方便理解一些。

// 如果说 nums 中不存在重复元素和缺失元素，那么每个元素就和唯一一个索引值对应，对吧？

// 现在的问题是，有一个元素重复了，同时导致一个元素缺失了，这会产生什么现象呢？会导致有两个元素对应到了同一个索引，而且会有一个索引没有元素对应过去。

// 那么，如果我能够通过某些方法，找到这个重复对应的索引，不就是找到了那个重复元素么？找到那个没有元素对应的索引，不就是找到了那个缺失的元素了么？

// 那么，如何不使用额外空间判断某个索引有多少个元素对应呢？这就是这个问题的精妙之处了：

// 通过将每个索引对应的元素变成负数，以表示这个索引被对应过一次了：
        /*
        0 1 2 3
        1,2,2,4
        
        0 1 2
        2 2 3
        */
        int n = nums.length;
        int dup = 0;
        for (int i = 0; i < n; i++) {
            //while and break
            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    dup = nums[i];
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        int mis = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                mis = i + 1;
            }
        }
        return new int[] {dup, mis};
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}