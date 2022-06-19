# Write your MySQL query statement below
SELECT w1.id FROM Weather w1, Weather w2 WHERE DATEDIFF(w1.Recorddate,w2.Recorddate) = 1 AND w1.temperature > w2.temperature