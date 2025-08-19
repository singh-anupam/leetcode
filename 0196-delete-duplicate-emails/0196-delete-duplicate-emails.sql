-- Write your PostgreSQL query statement below
delete from person p where p.id not in(select MIN(id) from person group by email )