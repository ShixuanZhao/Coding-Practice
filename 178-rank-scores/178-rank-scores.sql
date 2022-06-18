# Write your MySQL query statement below
##must rename s s.score
SELECT score, (SELECT COUNT(DISTINCT score) FROM Scores WHERE score >= s.score) AS "rank"
FROM Scores s ORDER BY score DESC