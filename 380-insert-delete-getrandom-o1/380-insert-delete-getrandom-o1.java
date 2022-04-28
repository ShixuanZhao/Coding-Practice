class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> indexMap;
    public RandomizedSet() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        list.set(index, list.get(list.size() - 1));
        indexMap.put(list.get(list.size() - 1), index);
        list.remove(list.size() - 1);
        indexMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */