# Write your MySQL query statement below
# empId is a foreign key to empId from the Employee table. it means some employee may not have bonus
# we should also return the employee that do not have bonus(null)
SELECT name, bonus FROM Employee e LEFT JOIN Bonus b on e.empId = b.empId WHERE bonus < 1000 OR bonus IS NULL;