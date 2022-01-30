class Solution {
    /*
    Basically we need to form some sort of key for each word to group them. (Remember the idea of group all anagrams?)
Consider acf and pru. Now notice the differnce between each characters.
acf = 0->2->3, and pru = 0->2->3. So these two form same group. So in this case, 
you can simply use integers ASCII difference to form key.
Now consider corner case, az and ba, where az = 0->25 and ba = 0->-1. When it goes negative,
 just make it positive(rotate or mod equivalent) by adding 26. So it becomes, ba = 0->25, which forms same group.
    */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            //the idea of group all anagrams
            String key = getKey(s);
            //"abc","bcd","xyz" key:11 11 11
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        //for one letter
        //sb.append(" ");
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            //corner case: az and ba should in same group
            if (diff < 0) {
                diff += 26;
            }
            sb.append(diff);
            //to diffenriate 1 1 and 11
            sb.append(",");
        }
        return sb.toString();
    }
}