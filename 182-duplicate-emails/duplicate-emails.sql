-- Write your PostgreSQL query statement below
select email from person group by email having count(email) > 1;