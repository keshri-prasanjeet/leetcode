-- Write your PostgreSQL query statement below
-- an id of customer that is never present in order

select c.name as Customers from customers c left join orders o on c.id = o.customerId where o.customerId is NULL;