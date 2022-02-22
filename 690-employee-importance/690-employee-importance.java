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
        return getSum(map, id);
    }
    
    private int getSum(Map<Integer, Employee> map, int id) {
        Employee master = map.get(id);
        int sum = master.importance;
        //n-nary tree
        for (Integer sub : master.subordinates) {
            sum += getSum(map, sub);
        }
        return sum;
    }
}