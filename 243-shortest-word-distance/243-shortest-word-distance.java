class Solution {
    // public int shortestDistance(String[] wordsDict, String word1, String word2) {
    //     //without hashmap, we can also use two list
    //     Map<String, List<Integer>> map = new HashMap<>();
    //     for (int i = 0; i < wordsDict.length; i++) {
    //         map.putIfAbsent(wordsDict[i], new ArrayList<>());
    //         map.get(wordsDict[i]).add(i);
    //     }
    //     List<Integer> list1 = map.get(word1);
    //     List<Integer> list2 = map.get(word2);
    //     int i = 0;
    //     int j = 0;
    //     int res = Integer.MAX_VALUE;
    //     while (i < list1.size() && j < list2.size()) {
    //         res = Math.min(res, Math.abs(list2.get(j) - list1.get(i)));
    //         if (list1.get(i) < list2.get(j)) {
    //             i++;
    //         } else {
    //             j++;
    //         }
    //     }
    //     return res;
    // }
    
    public int shortestDistance(String[] words, String word1, String word2) {
    int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) 
            p1 = i;

        if (words[i].equals(word2)) 
            p2 = i;
            
        if (p1 != -1 && p2 != -1)
            min = Math.min(min, Math.abs(p1 - p2));
    }
    
    return min;
}
}