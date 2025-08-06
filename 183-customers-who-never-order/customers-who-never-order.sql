-- Write your PostgreSQL query statement below
-- an id of customer that is never present in order

select c.name as Customers from Customers c left join Orders o on c.id = o.customerId where o.customerId IS NULL;