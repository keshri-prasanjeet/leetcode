-- Write your PostgreSQL query statement below
select name from customer where coalesce(referee_id,0) != 2;