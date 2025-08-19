-- Write your PostgreSQL query statement below
select player_id, event_date as first_login from 
(select rank() over (partition by player_id order by event_date asc) rn,
player_id,
event_date
from Activity)
where rn =1