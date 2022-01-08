class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            //find the index of " "
            int i = s.indexOf(' ');
            int n = Integer.valueOf(s.substring(0, i));
            String s1 = s.substring(i + 1);
            map.put(s1, map.getOrDefault(s1, 0) + n);
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '.') {
                    String d = s1.substring(j + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}