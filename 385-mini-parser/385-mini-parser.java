/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        int n = s.length();
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.valueOf(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int left = 1;
        int right = 1;
        NestedInteger res = new NestedInteger();
        stack.offerFirst(res);
        for (; right < s.length(); right++) {
            if (s.charAt(right) == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peekFirst().add(ni);
                stack.offerFirst(ni);
                left = right + 1;
            } else if (s.charAt(right) == ',' || s.charAt(right) == ']') {
                //corner case empty list
                if (left < right) {
                    NestedInteger ni = new NestedInteger(Integer.valueOf(s.substring(left, right)));    
                    stack.peekFirst().add(ni);
                }
                if (s.charAt(right) == ']') {
                    stack.pollFirst();
                }
                left = right + 1;
            }
        }
        return res;
    }
}