-- Write your PostgreSQL query statement below
select e.name, b.bonus from Employee e left join Bonus b on e.empid = b.empId where bonus < 1000 OR bonus IS NULL;