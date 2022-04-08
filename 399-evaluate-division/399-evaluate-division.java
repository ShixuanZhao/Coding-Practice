class Solution {
    //it is a directed weighted graph无向有权图
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            m.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            m.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            m.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            m.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        //visited must be each dfs call have one set
        // Set<String> visited = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            Set<String> visited = new HashSet<>();
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), m, visited);
        }
        return res;
    }
    
    private double dfs(String start, String end, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (map.get(start) == null) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        for (Map.Entry<String, Double> nei: map.get(start).entrySet()) {
            if (visited.add(nei.getKey())) {
                double weight = dfs(nei.getKey(), end, map, visited);
                if (weight != -1.0) {
                    return nei.getValue() * weight;
                }
            }
        }
        return -1.0;
    }
}