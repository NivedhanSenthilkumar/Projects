use ecommerce;

-- Functions
select calcTotal(7);-- To calculate the Total amount a Customer has to pay after Shipping


select * from rating;
select calcAvgRatingForProduct(11);-- To calculate Average rating for a Product


-- Procedures
select * from order1;
call calctotalOrders(17);-- To calculate total orders for a Customer

select * from invoice;
call changeInvoiceStatus(6);-- To change the Invoice Status to Paid if the Payment for that Invoicce is Paid


-- Views

select * from product;
select * from `Top 3 Products`;-- To find the Top 3 Products
select * from `Products and Ratings`;-- To Display products along with their average ratings 

-- To show the working of Before Insert trigger on Product
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('IPhone X',15,'Great phone',40,9,15);
select * from product;

-- To show the working of Before Insert & After Insert trigger on Product
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(10,23,1);
select * from product;
select * from order_has_product;


-- Queries

-- To find out all the cart items in a Customers cart
select c.CartId, CustomerID, product.productId, product.productName, c.Quantity
from cart c inner join customer cu on c.CartId = cu.cart_CartId 
			inner join  product on product.Cart_CartId = c.CartId
where cu.Name = 'Milony'
order by CustomerID;


-- To find all the products ordered by a customer
select c.CustomerID , c.Name, p.productName, o.Quantity
from customer c inner join order1 on c.CustomerID = order1.Customer_CustomerID 
				inner join order_has_product o on order1.orderID=o.order_orderID
                inner join product p on o.product_productId = p.productId
where c.Name='Milony';
      