# Write your MySQL query statement below
#Because there are possible for empty 'Department', 'Employee' cannot find the department.
#That's why it should adopt INNER JOIN instead. (intersection)
# Since the Employee table contains the Salary and DepartmentId information, we can query the highest salary in a department.
# SELECT
#     DepartmentId, MAX(Salary)
# FROM
#     Employee
# GROUP BY DepartmentId;
SELECT D.name AS "Department", E.name AS "Employee", E.salary AS "Salary" FROM
Employee E INNER JOIN Department D ON E.departmentId = D.id 
WHERE (E.departmentId, E.salary) IN (SELECT departmentId, MAX(salary) FROM Employee GROUP BY departmentId)