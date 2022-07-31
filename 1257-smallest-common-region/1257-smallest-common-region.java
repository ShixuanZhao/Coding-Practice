class Solution {
    //LCA with parent node
    //1.construct n-ary tree with parent node
    //2.find the lca
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        //(child, parent)
        Map<String, String> map = new HashMap<>();
        for (List<String> cur : regions) {
            for (int i = 1; i < cur.size(); i++) {
                map.put(cur.get(i), cur.get(0));
            }
        }
        int len1 = getLength(map, region1);
        int len2 = getLength(map, region2);
        if (len1 < len2) {
            int diff = len2 - len1;
            while (diff > 0) {
                region2 = map.get(region2);
                diff--;
            }
        } else {
            int diff = len1 - len2;
            while (diff > 0) {
                region1 = map.get(region1);
                diff--;
            }
        }
        while (!region1.equals(region2)) {
            region1 = map.get(region1);
            region2 = map.get(region2);
        }
        return region1;
    }
    
    private int getLength(Map<String, String> map, String region) {
        int res = 1;
        while (region != null) {
            region = map.getOrDefault(region, null);
            res++;
        }
        return res;
    }
}