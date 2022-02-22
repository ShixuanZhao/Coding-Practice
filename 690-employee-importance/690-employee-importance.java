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
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getSum(map, id);
    }
    
    private int getSum(Map<Integer, Employee> map, int id) {
        Employee master = map.get(id);
        int sum = master.importance;
        for (Integer sub : master.subordinates) {
            sum += getSum(map, sub);
        }
        return sum;
    }
}