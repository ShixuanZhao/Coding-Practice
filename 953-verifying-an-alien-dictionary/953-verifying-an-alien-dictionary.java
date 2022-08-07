class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        //<Character, index>
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }
        //compare each pair in the words arr
        for (int index = 1; index < words.length; index++) {
            String prev = words[index - 1];
            String cur = words[index];
            int i = 0;
            int j = 0;
            while (i < prev.length() && j < cur.length()) {
                char prevChar = prev.charAt(i);
                char curChar = cur.charAt(j);
                int prevIndex = indexMap.get(prevChar);
                int curIndex = indexMap.get(curChar);
                if (prevIndex < curIndex) {
                    break;
                } else if (prevIndex == curIndex){
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
            //apple app return false
            if (j == cur.length() && i < prev.length()) {
                return false;
            }
        }
        return true;
    }
}