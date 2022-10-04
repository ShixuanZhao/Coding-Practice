class Solution {
    /*
        Pair<timestamp, website>
        1.group 3 array by username with a map<UserNames, List<Pair>>
        2.enumerate all the pattern for each user and put it into a count map, update the freq
        3.return the most freq pattern
    */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //define pair class
        class Pair {
            int timestamp;
            String website;
            public Pair(int timestamp, String website) {
                this.timestamp = timestamp;
                this.website = website;
            }
        }
        //step1
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        //step2
        Map<String, Integer> freqMap = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            //use a hashset to avoid duplicate pattern for one user
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            //sort by time from small to large
            Collections.sort(list, (a, b) -> (a.timestamp - b.timestamp));
            //brute force
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(list.get(i).website).append(" ").append(list.get(j).website).append(" ").append(list.get(k).website);
                        String str= sb.toString();         
                        if (!set.contains(str)) {
                            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || freqMap.get(res) < freqMap.get(str) ||
                            (freqMap.get(res) == freqMap.get(str) && str.compareTo(res) < 0)) {
                                res = str;
                        }
                    }
                }
            }    
        }
        // grab the right answer
        String[] r = res.split(" ");
        List<String> result = new ArrayList<>();
        for (String str : r) {
            result.add(str);
        }
         return result;
    }                       
}