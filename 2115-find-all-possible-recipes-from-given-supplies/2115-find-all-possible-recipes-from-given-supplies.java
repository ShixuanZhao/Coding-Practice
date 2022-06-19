class Solution {
// For each recipe, count its dependent ingredients as in degree; Store (ingredient, recipes that dependent on it) as HashMap;
// Use the supplies as the starting points of topological sort;
// Use topogical sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String in : ingredients.get(i)) {
                ingredientToRecipes.putIfAbsent(in, new ArrayList<>());
                ingredientToRecipes.get(in).add(recipes[i]);
            }
            indegree.put(recipes[i], ingredients.get(i).size());
        }
        Queue<String> q = new LinkedList<>();
        for (String s : supplies) {
            q.add(s);
        }
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String nei : ingredientToRecipes.getOrDefault(cur, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    q.offer(nei);
                    res.add(nei);
                }
            }
        }
        return res;
    }
}