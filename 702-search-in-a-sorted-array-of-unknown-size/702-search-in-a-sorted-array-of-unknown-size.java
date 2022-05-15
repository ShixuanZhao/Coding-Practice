/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while(reader.get(end)< target) {
            end = end*2;
        }
        start = end / 2;
        while(start<=end) {
             int mid = (start+end)/2;
             if(reader.get(mid) == target){
                 return mid;
             } else if(reader.get(mid)>target) {
                 end = mid-1;
             } else {
                 start = mid+1;
             }
        }
        return -1;
    }
}