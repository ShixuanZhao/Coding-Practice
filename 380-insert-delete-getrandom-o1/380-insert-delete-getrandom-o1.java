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

//  class RandomizedSet {
// //     动态数组存储元素值
// // 哈希表存储存储值到索引的映射
//      //这样查找元素就是O（1）
//      //valToIndex
//   Map<Integer, Integer> dict;
//   List<Integer> list;
//   Random rand = new Random();

//   /** Initialize your data structure here. */
//   public RandomizedSet() {
//     dict = new HashMap();
//     list = new ArrayList();
//   }

//   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
// //     添加元素到动态数组。
// // 在哈希表中添加值到索引的映射
//   public boolean insert(int val) {
//     if (dict.containsKey(val)) return false;

//     dict.put(val, list.size());
//     list.add(list.size(), val);
//     return true;
//   }
    
// // 在哈希表中查找要删除元素的索引。
// // 将要删除元素与最后一个元素交换。
// // 删除最后一个元素。
// // 更新哈希表中的对应关系。
// //     对数组尾部进行插入和删除操作不会涉及数据搬移，时间复杂度是 O(1)
// //     所以，如果我们想在 O(1) 的时间删除数组中的某一个元素 val，可以先把这个元素交换到数组的尾部，然后再 pop 掉。
// //     交换两个元素必须通过索引进行交换对吧，那么我们需要一个哈希表 valToIndex 来记录每个元素值对应的索引。
//   /** Removes a value from the set. Returns true if the set contained the specified element. */
//   public boolean remove(int val) {
//     if (! dict.containsKey(val)) return false;

//     // move the last element to the place idx of the element to delete
//     int lastElement = list.get(list.size() - 1);
//     int idx = dict.get(val);
//     //O(1)because we use ArrayList
//     list.set(idx, lastElement);
//     dict.put(lastElement, idx);
//     // delete the last element
//     list.remove(list.size() - 1);
//     dict.remove(val);
//     return true;
//   }

//   /** Get a random element from the set. */
//   public int getRandom() {
//     return list.get(rand.nextInt(list.size()));
//   }
// }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */