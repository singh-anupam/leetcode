-- Write your PostgreSQL query statement below
select customer_number from
(select customer_number , count(customer_number) from Orders group by customer_number limit 1)
