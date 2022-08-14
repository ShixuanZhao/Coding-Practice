/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //BFS
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));
        int res = 0;
        while (!q.isEmpty()) {
            Employee cur = q.poll();
            res += cur.importance;
            for (Integer sub : cur.subordinates) {
                q.offer(map.get(sub));
            }
        }
        return res;
    }
}