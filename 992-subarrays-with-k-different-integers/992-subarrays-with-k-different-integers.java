class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    /*
    why j - i + 1?
    suppose initial window [a] then subarrays that ends with this element are [a]--> 1
now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
[b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3

You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting of duplicate subarrays that we already considered previously.
And surprisingly the number of sub-arrays with this new element in it is equal to the length of current window.
    */
   private int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (map.size() > K) {
                int cnt = map.get(A[i]);
                map.put(A[i], --cnt);
                if (cnt == 0) {
                    map.remove(A[i]);
                }
                i++;
            }
            //the number of subarray
            /*
            [1,2,1,2,3] at most 2 ele
             i
                 j
             res:1 + 2 + 3
             when new ele come, we can form j - i + 1 new subarray(ending at index j)
            */
            res += j - i + 1;
        }
        return res;
    }
}