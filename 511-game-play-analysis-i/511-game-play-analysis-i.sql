# Write your MySQL query statement below
#for each player. so we think about using group by and do aggregation MIN
select player_id, min(event_date) as first_login
from activity 
group by player_id