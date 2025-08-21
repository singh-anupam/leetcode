-- Write your PostgreSQL query statement below

select p.firstName , p.lastName , a.city, a.state 
from person p left Join  address a
on p.personId = a.personId
