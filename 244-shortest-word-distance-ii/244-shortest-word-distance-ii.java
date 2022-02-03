class WordDistance {

    private Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if(map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(w, list);
            }
        }
    }
    
    /*
        q:two ascending arr, find the pair which has the min diff, return the diff
        [1, 3, 4]
               i
        [2, 5]
            j
        min = 1
        [2]
           i
        [3 5 6]
         j
         min = 1
    */
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        //if one pointer out of boundary, we should termionate because other pairs diff would be larger
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                i++;
            } else {
                res = Math.min(res, index1 - index2);
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */