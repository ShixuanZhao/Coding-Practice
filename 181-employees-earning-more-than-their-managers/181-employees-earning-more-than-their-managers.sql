# Write your MySQL query statement below
## As this table has the employee's manager information, we probably need to select information from it twice.
SELECT a.name AS "Employee" FROM Employee a, Employee b
WHERE a.managerId = b.id AND a.salary > b.salary