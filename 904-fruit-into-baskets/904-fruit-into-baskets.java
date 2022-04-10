class Solution {
    //hashmap sliding window
    // public int totalFruit(int[] fruits) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int left = 0;
    //     int res = 0;
    //     for (int i = 0; i < fruits.length; i++) {
    //         map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
    //         while (map.size() > 2) {
    //             map.put(fruits[left], map.get(fruits[left]) - 1);
    //             if (map.get(fruits[left]) == 0) {
    //                 map.remove(fruits[left]);
    //             }
    //             left++;
    //         }
    //         res = Math.max(res, i - left + 1);
    //     }
    //     return res;
    // }
    
    
    //another solution without hashmap
    //Find out the longest length of subarrays with at most 2 different numbers?
    public int totalFruit(int[] fruits) {
        //last kind of fruit
        int last = -1;
        int second = -1;
        int lastCnt = 0;
        int curMax = 0;
        int res = 0;
        for (int fruit : fruits) {
            if (fruit == last || fruit == second) {
                curMax++;
            } else {
                curMax = lastCnt + 1;// last fruit + new fruit
            }
            
            if (fruit == last) {
                lastCnt++;
            } else {
                lastCnt = 1;
                second = last;
                last = fruit;
            }
            res = Math.max(res, curMax);
        }
        return res;
    }
}