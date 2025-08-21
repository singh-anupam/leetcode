-- Write your PostgreSQL query statement below
select e.name as Employee, e.salary as Salary , d.name as Department
from Employee e
join 
department d
on e.departmentId =d.id
where 
(e.departmentId,e.salary) in
(select e.departmentId, Max(salary)
from employee e
join department d
on e.departmentId =d.id
group by e.departmentId)