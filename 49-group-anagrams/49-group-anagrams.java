class Solution {
    /*
        use a HashMap to group the anagrams
        key:the sorted string, value: a list of anagrams
        ["ate","eat","tea"]
        we find if we sort the anagram by lexiographcal order, they all would be aet, we set aet as key
        aet-> [ate, eat, tea]
        return all the values in the map
    */
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(s);
        }
        return new LinkedList<>(map.values());
    }
}