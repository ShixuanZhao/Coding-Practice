# Write your MySQL query statement
SELECT count(DISTINCT(customer_id)) AS rich_count 
FROM store WHERE amount > 500