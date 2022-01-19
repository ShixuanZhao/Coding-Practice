class Solution {
    public String longestCommonPrefix(String[] strs) {
        //字典排序后，第一个串与最后一个串差异最大，找他们两的公共前缀，就是所有子串的公共前缀
        if (strs.length == 0) {
            return "";
        }
        
        // 字典排序
        Arrays.sort(strs);
        // 取排序后第一个串
        String start = strs[0];
        String end = strs[strs.length - 1];
        // 取最后一个串与第一个串进行比较，取他们两个都有的公共前缀为最终结果
        for (int i = 0; i < Math.min(start.length(), end.length()); i++) {
            while (i < Math.min(start.length(), end.length()) && start.charAt(i) == end.charAt(i)) {
                i++;
            }
            return start.substring(0, i);
        }
        return "";
    }
}