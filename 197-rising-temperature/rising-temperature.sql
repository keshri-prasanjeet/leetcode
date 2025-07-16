-- Write your PostgreSQL query statement below
select w1.id from weather w1 inner join weather w2 on w1.recordDate = w2.recordDate + INTERVAL '1 DAY' where w2.temperature < w1.temperature;