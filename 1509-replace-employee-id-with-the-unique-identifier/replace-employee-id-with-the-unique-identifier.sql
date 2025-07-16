-- Write your PostgreSQL query statement below
select eu.unique_id, e.name from employeeuni eu right join employees e on eu.id=e.id;