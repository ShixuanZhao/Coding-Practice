/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //注意类比到一个tree，就是求以root为根节点的树所有节点的和
        //dfs
        //construct a Hashmap to use id as index
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getVal(map, id);
    }

    private int getVal(Map<Integer, Employee> map, int id) {
        int total = 0;
        Employee master = map.get(id);
        total = master.importance;
        //n-nary tree
        for (int sub : master.subordinates) {
            total += getVal(map, sub);
        }
        return total;
    
    }
}