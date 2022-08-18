class DetectSquares {
    List<int[]> points;
    Map<String, Integer> countMap;
    public DetectSquares() {
        points = new ArrayList<>();
        countMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String key = point[0] + "," + point[1];
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int res = 0;
        for (int[] p : points) {
            //find the valid p3
            if (Math.abs(p[0] - x1) == Math.abs(p[1] - y1) && p[0] != x1) {
                //find the valid p2 and p4
                //p2:(p[0],y1) p4:(x1, p[1])
                res += countMap.getOrDefault(p[0] + "," + y1, 0) * countMap.getOrDefault(x1 + "," + p[1], 0); 
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */