# Write your MySQL query statement below

#M1 fastest
#SELECT C.name AS "Customers" FROM Customers C LEFT JOIN Orders O ON C.id = O.customerId WHERE O.customerId is NULL 

# M2:
select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);