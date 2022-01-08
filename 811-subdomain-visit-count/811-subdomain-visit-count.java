class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            //find the index of " "
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            map.put(s, map.getOrDefault(s, 0) + n);
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
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