-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8 ;
USE `ecommerce` ;

-- -----------------------------------------------------
-- Table `ecommerce`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`invoice` (
  `InvoiceId` INT(11) NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`InvoiceId`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`payment` (
  `PaymentId` INT(11) NOT NULL AUTO_INCREMENT,
  `PaymentStatus` VARCHAR(45) NULL DEFAULT NULL,
  `invoice_InvoiceId` INT(11) NOT NULL,
  PRIMARY KEY (`PaymentId`, `invoice_InvoiceId`),
  INDEX `fk_Payment_invoice1_idx` (`invoice_InvoiceId` ASC),
  CONSTRAINT `fk_Payment_invoice1`
    FOREIGN KEY (`invoice_InvoiceId`)
    REFERENCES `ecommerce`.`invoice` (`InvoiceId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`cart` (
  `CartId` INT(11) NOT NULL AUTO_INCREMENT,
  `CartPrice` DOUBLE NULL DEFAULT NULL,
  `Quantity` INT(11) NULL DEFAULT NULL,
  `Date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`CartId`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`customer` (
  `CustomerID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Gender` VARCHAR(1) NULL DEFAULT NULL,
  `DateOfBirth` DATE NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Payment_PaymentId` INT(11) NOT NULL,
  `cart_CartId` INT(11) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  INDEX `fk_customer_Payment1_idx` (`Payment_PaymentId` ASC),
  INDEX `fk_customer_cart1_idx` (`cart_CartId` ASC),
  CONSTRAINT `fk_customer_Payment1`
    FOREIGN KEY (`Payment_PaymentId`)
    REFERENCES `ecommerce`.`payment` (`PaymentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_cart1`
    FOREIGN KEY (`cart_CartId`)
    REFERENCES `ecommerce`.`cart` (`CartId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`address` (
  `AddressID` INT(11) NOT NULL AUTO_INCREMENT,
  `Street` VARCHAR(45) NULL DEFAULT NULL,
  `City` VARCHAR(45) NULL DEFAULT NULL,
  `State` VARCHAR(45) NULL DEFAULT NULL,
  `Zipcode` INT(11) NULL DEFAULT NULL,
  `Customer_CustomerID` INT(11) NOT NULL,
  PRIMARY KEY (`AddressID`),
  INDEX `fk_Address_Customer1_idx` (`Customer_CustomerID` ASC),
  CONSTRAINT `fk_Address_Customer1`
    FOREIGN KEY (`Customer_CustomerID`)
    REFERENCES `ecommerce`.`customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`category` (
  `CategoryID` INT(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`CategoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`product` (
  `productId` INT(11) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(45) NULL DEFAULT NULL,
  `productCost` INT(11) NULL DEFAULT NULL,
  `productPrice` INT(11) NULL DEFAULT NULL,
  `productDescription` VARCHAR(100) NULL DEFAULT NULL,
  `InStock` INT(11) NULL DEFAULT NULL,
  `OnOrder` INT(11) NULL DEFAULT NULL,
  `Cart_CartId` INT(11) NULL DEFAULT NULL,
  `Category_CategoryID` INT(11) NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `fk_product_Category1_idx` (`Category_CategoryID` ASC),
  CONSTRAINT `fk_product_Category1`
    FOREIGN KEY (`Category_CategoryID`)
    REFERENCES `ecommerce`.`category` (`CategoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`cart_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`cart_has_product` (
  `Cart_CartId` INT(11) NOT NULL,
  `product_productId` INT(11) NOT NULL,
  PRIMARY KEY (`Cart_CartId`, `product_productId`),
  INDEX `fk_Cart_has_product_product1_idx` (`product_productId` ASC),
  INDEX `fk_Cart_has_product_Cart1_idx` (`Cart_CartId` ASC),
  CONSTRAINT `fk_Cart_has_product_Cart1`
    FOREIGN KEY (`Cart_CartId`)
    REFERENCES `ecommerce`.`cart` (`CartId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cart_has_product_product1`
    FOREIGN KEY (`product_productId`)
    REFERENCES `ecommerce`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`shipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`shipment` (
  `ShipmentId` INT(11) NOT NULL AUTO_INCREMENT,
  `ShipmentType` VARCHAR(45) NULL DEFAULT NULL,
  `ShipmentPrice` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`ShipmentId`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`order1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`order1` (
  `orderID` INT(11) NOT NULL AUTO_INCREMENT,
  `OrderDate` DATE NULL DEFAULT NULL,
  `Customer_CustomerID` INT(11) NOT NULL,
  `Shipment_ShipmentId` INT(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `fk_order_Customer1_idx` (`Customer_CustomerID` ASC),
  INDEX `fk_order_Shipment1_idx` (`Shipment_ShipmentId` ASC),
  CONSTRAINT `fk_order_Customer1`
    FOREIGN KEY (`Customer_CustomerID`)
    REFERENCES `ecommerce`.`customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_Shipment1`
    FOREIGN KEY (`Shipment_ShipmentId`)
    REFERENCES `ecommerce`.`shipment` (`ShipmentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`order_has_product` (
  `orderDetailID` INT(11) NOT NULL AUTO_INCREMENT,
  `order_orderID` INT(11) NOT NULL,
  `product_productId` INT(11) NOT NULL,
  `Quantity` INT(11) NULL DEFAULT NULL,
  `orderPrice` INT(11) NOT NULL,
  `Total` INT(11) NOT NULL,
  PRIMARY KEY (`orderDetailID`),
  INDEX `fk_order_has_product_product1_idx` (`product_productId` ASC),
  INDEX `fk_order_has_product_order1_idx` (`order_orderID` ASC),
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_orderID`)
    REFERENCES `ecommerce`.`order1` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_productId`)
    REFERENCES `ecommerce`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`invoice_line`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`invoice_line` (
  `Invoice_LineID` INT(11) NOT NULL AUTO_INCREMENT,
  `InvoicePrice` INT(11) NULL DEFAULT NULL,
  `order_has_product_orderDetailID` INT(11) NOT NULL,
  `Invoice_InvoiceId` INT(11) NOT NULL,
  PRIMARY KEY (`Invoice_LineID`),
  INDEX `fk_Invoice_Line_order_has_product1_idx` (`order_has_product_orderDetailID` ASC),
  INDEX `fk_Invoice_Line_Invoice1_idx` (`Invoice_InvoiceId` ASC),
  CONSTRAINT `fk_Invoice_Line_Invoice1`
    FOREIGN KEY (`Invoice_InvoiceId`)
    REFERENCES `ecommerce`.`invoice` (`InvoiceId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Line_order_has_product1`
    FOREIGN KEY (`order_has_product_orderDetailID`)
    REFERENCES `ecommerce`.`order_has_product` (`orderDetailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`rating` (
  `RatingID` INT(11) NOT NULL AUTO_INCREMENT,
  `rating` INT(11) NULL DEFAULT NULL,
  `customer_CustomerID` INT(11) NOT NULL,
  `product_productId` INT(11) NOT NULL,
  PRIMARY KEY (`RatingID`),
  INDEX `fk_rating_customer1_idx` (`customer_CustomerID` ASC),
  INDEX `fk_rating_product1_idx` (`product_productId` ASC),
  CONSTRAINT `fk_rating_customer1`
    FOREIGN KEY (`customer_CustomerID`)
    REFERENCES `ecommerce`.`customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_product1`
    FOREIGN KEY (`product_productId`)
    REFERENCES `ecommerce`.`product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

USE `ecommerce` ;

-- -----------------------------------------------------
-- Placeholder table for view `ecommerce`.`products and ratings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`products and ratings` (`productId` INT, `productName` INT, `productDescription` INT, `Rating` INT);

-- -----------------------------------------------------
-- Placeholder table for view `ecommerce`.`top 3 products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`top 3 products` (`productId` INT, `productName` INT, `productCost` INT, `productPrice` INT, `productDescription` INT, `InStock` INT, `OnOrder` INT, `Cart_CartId` INT, `Category_CategoryID` INT);

-- -----------------------------------------------------
-- function calcAvgRatingForProduct
-- To calculate Average rating of a Product
-- -----------------------------------------------------

DELIMITER $$
USE `ecommerce`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calcAvgRatingForProduct`(Id int) RETURNS decimal(9,2)
BEGIN
  DECLARE avgRating DECIMAL(9,2);
  SET avgRating = (select Avg(rating.rating)
					from rating
                    where product_productId = id);
  RETURN avgRating;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function calcTotal
-- To calculate Total amount for a customers Order
-- -----------------------------------------------------

DELIMITER $$
USE `ecommerce`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `calcTotal`(Id int) RETURNS decimal(9,2)
BEGIN
  DECLARE profit DECIMAL(9,2);
  SET profit = (select Sum(i.invoicePrice)
				from customer c inner join order1 o on o.Customer_CustomerID=c.CustomerID 
                inner join order_has_product op on op.order_orderID=o.orderID
                inner join invoice_line i on i.order_has_product_orderDetailID = op.orderDetailID
                where c.CustomerID = id);
  RETURN profit;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure calctotalOrders
-- To calculate Total orders of a Customer
-- -----------------------------------------------------

DELIMITER $$
USE `ecommerce`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `calctotalOrders`(IN param1 INT)
BEGIN
SELECT COUNT(*) as `Total Order`
from customer c inner join order1 on c.CustomerID = order1.Customer_CustomerID
where c.CustomerID = param1
group by c.CustomerID;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure changeInvoiceStatus
-- To change the Invoice Status to Paid if the Payment for that Invoicce is Paid
-- -----------------------------------------------------

DELIMITER $$
USE `ecommerce`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `changeInvoiceStatus`(IN param1 int)
BEGIN

		DECLARE xname VARCHAR(20);
        
        set xname = (select paymentStatus
					from payment
					where invoice_Invoiceid=param1);
		if
			xname = 'Paid'
		then
			if exists (select * from invoice where invoiceId = param1)
            then
				update invoice
                set status = xname where invoiceId = param1;
			end if ;
		End If ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- View `ecommerce`.`products and ratings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecommerce`.`products and ratings`;
USE `ecommerce`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ecommerce`.`products and ratings` AS select distinct `ecommerce`.`product`.`productId` AS `productId`,`ecommerce`.`product`.`productName` AS `productName`,`ecommerce`.`product`.`productDescription` AS `productDescription`,(select avg(`ecommerce`.`rating`.`rating`) from `ecommerce`.`rating` where (`ecommerce`.`product`.`productId` = `ecommerce`.`rating`.`product_productId`)) AS `Rating` from (`ecommerce`.`product` join `ecommerce`.`rating`) where (`ecommerce`.`product`.`productId` = `ecommerce`.`rating`.`product_productId`);

-- -----------------------------------------------------
-- View `ecommerce`.`top 3 products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecommerce`.`top 3 products`;
USE `ecommerce`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ecommerce`.`top 3 products` AS select `ecommerce`.`product`.`productId` AS `productId`,`ecommerce`.`product`.`productName` AS `productName`,`ecommerce`.`product`.`productCost` AS `productCost`,`ecommerce`.`product`.`productPrice` AS `productPrice`,`ecommerce`.`product`.`productDescription` AS `productDescription`,`ecommerce`.`product`.`InStock` AS `InStock`,`ecommerce`.`product`.`OnOrder` AS `OnOrder`,`ecommerce`.`product`.`Cart_CartId` AS `Cart_CartId`,`ecommerce`.`product`.`Category_CategoryID` AS `Category_CategoryID` from `ecommerce`.`product` order by `ecommerce`.`product`.`OnOrder` limit 3;
USE `ecommerce`;


-- Calculates the Selling price of a Product
DELIMITER $$
USE `ecommerce`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ecommerce`.`product_BEFORE_INSERT`
BEFORE INSERT ON `ecommerce`.`product`
FOR EACH ROW
BEGIN
	SET NEW.productprice = NEW.productcost * 2;
END$$

USE `ecommerce`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ecommerce`.`product_BEFORE_UPDATE`
BEFORE UPDATE ON `ecommerce`.`product`
FOR EACH ROW
BEGIN
		IF NEW.productcost <> OLD.productcost
    THEN
      SET NEW.productprice = NEW.productcost * 2;
  END IF ;
END$$


-- Calculate the Total amount of that Order and updates the Instock and OnOrder of the Product
USE `ecommerce`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ecommerce`.`order_has_product_AFTER_INSERT`
AFTER INSERT ON `ecommerce`.`order_has_product`
FOR EACH ROW
BEGIN
		if new.quantity < (select inStock from product p where new.product_productId = p.productId)
        then
		update product
        set product.inStock = product.instock - new.quantity,
			product.onOrder = product.onOrder + new.quantity
        where new.product_productId = product.productId;
        end if;
        
END$$

USE `ecommerce`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ecommerce`.`order_has_product_BEFORE_INSERT`
BEFORE INSERT ON `ecommerce`.`order_has_product`
FOR EACH ROW
BEGIN
	if new.quantity < (select inStock from product p where new.product_productId = p.productId)
    then
	set New.orderprice = (select productPrice from product where product.productId = new.product_productID );
	set NEW.total = New.orderprice * new.quantity;
    end if;
END$$


-- Calculates the toatl Amount the Customer has to pay. This sums the invoice and shipment prices 
USE `ecommerce`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ecommerce`.`invoice_line_BEFORE_INSERT`
BEFORE INSERT ON `ecommerce`.`invoice_line`
FOR EACH ROW
BEGIN
	Declare op int;
    declare sp int;
    
    set sp = (select shipmentPrice from shipment s, order1 od, order_has_product o where o.orderdetailid = new.order_has_product_orderDetailID and o.order_orderID = od.orderID and od.Shipment_ShipmentId = s.shipmentID);
    set op = (select orderPrice from order_has_product o where o.orderDetailId = new.order_has_product_orderDetailID);
	set	new.invoicePrice = op + sp;
    
    
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Insert Statements for all Tables



insert into invoice (invoice.Status) values ('Pending');
insert into invoice (invoice.Status) values ('Pending');
insert into invoice (invoice.Status) values ('Pending');
insert into invoice (invoice.Status) values ('Pending');
select * from invoice;


insert into payment (PaymentStatus,invoice_InvoiceId) values ('Paid',9);
insert into payment (PaymentStatus,invoice_InvoiceId) values ('Pending',10);
insert into payment (PaymentStatus,invoice_InvoiceId) values ('Paid',11);
insert into payment (PaymentStatus,invoice_InvoiceId) values ('Paid',12);
insert into payment (PaymentStatus,invoice_InvoiceId) values ();
select * from payment;


insert into customer (name,gender,dateOfBirth,email,payment_paymentID,cart_cartId) values('Milony', 'F','1995/11/17','milony@gmail.com',18,9);
insert into customer (name,gender,dateOfBirth,email,payment_paymentID,cart_cartId) values('Birwa', 'F','1995/12/17','birwa@gmail.com',19,10);
insert into customer (name,gender,dateOfBirth,email,payment_paymentID,cart_cartId) values('Rugvedi', 'F','1995/12/25','rugvedi@gmail.com',20,11);
insert into customer (name,gender,dateOfBirth,email,payment_paymentID,cart_cartId) values('Devyani', 'F','1993/09/06','devyani@gmail.com',21,12);
select * from customer;


insert into address (Street, City, State, Zipcode, customer_customerID) values ('75 Peterbotough','Boston','MA',02215,11);
insert into address (Street, City, State, Zipcode, customer_customerID) values ('75 Alphanso','Boston','MA',02215,12);
insert into address (Street, City, State, Zipcode, customer_customerID) values ('100 Jeresey','Boston','MA',02215,13);
insert into address (Street, City, State, Zipcode, customer_customerID) values ('75 Peterbotough','Boston','MA',02215,14);
select * from address;


insert into cart (cartPrice, quantity, date) values (200,5,'2017/12/12');
insert into cart (cartPrice, quantity, date) values (25,2,'2017/10/10');
insert into cart (cartPrice, quantity, date) values (100,3,'2017/02/02');
insert into cart (cartPrice, quantity, date) values (60,2,'2017/05/03');
select * from cart;


insert into category (categoryName) values ('Shoes');
insert into category (categoryName) values ('Bags');
insert into category (categoryName) values ('Clothes');
insert into category (categoryName) values ('Watches');
insert into category (categoryName) values ('Electronics');
select * from category;


insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('Nike',20,'great shoes',10,9,11);
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('WildCraft',10,'great bags',13,10,12);
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('Timex',10,'great watches',07,11,14);
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('H&M',10,'great clothes',40,12,13);
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('Zara',12,'great clothes',40,11,13);
insert into product(productName, productcost,productDescription,Instock,cart_cartID,category_categoryId) values ('IPad',15,'great Tabs',40,9,15);
select * from product;


insert into cart_has_product values (9,17);
insert into cart_has_product values (10,18);
insert into cart_has_product values (11,19);
insert into cart_has_product values (12,20);
select * from cart_has_product;


insert into shipment (shipmentType, shipmentPrice) values ('UPS',20);
insert into shipment (shipmentType, shipmentPrice) values ('FedEx',15);
insert into shipment (shipmentType, shipmentPrice) values ('USPS',10);
insert into shipment (shipmentType, shipmentPrice) values ('FedEx',15);
select * from shipment;


insert into order1 (OrderDate, Customer_CustomerID, Shipment_ShipmentId) values ('2017/02/12',11,9);
insert into order1 (OrderDate, Customer_CustomerID, Shipment_ShipmentId)values ('2017/09/02',12,10);
insert into order1 (OrderDate, Customer_CustomerID, Shipment_ShipmentId) values ('2017/10/22',13,11);
insert into order1 (OrderDate, Customer_CustomerID, Shipment_ShipmentId) values ('2017/05/17',14,12);
select * from order1;


insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(9,17,2);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(10,18,3);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(11,19,2);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(12,18,5);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(9,22,5);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(10,20,5);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(12,21,5);
insert into order_has_product (order_orderID, product_productID,order_has_product.Quantity)values(10,20,5);
select * from order_has_product; 


insert into invoice_line (order_has_product_orderDetailID,Invoice_InvoiceId) values (13,9);
insert into invoice_line (order_has_product_orderDetailID,Invoice_InvoiceId) values (14,10);
insert into invoice_line (order_has_product_orderDetailID,Invoice_InvoiceId) values (15,11);
insert into invoice_line (order_has_product_orderDetailID,Invoice_InvoiceId) values (16,12);
insert into invoice_line (order_has_product_orderDetailID,Invoice_InvoiceId) values (13,9);
select * from invoice_line;


insert into rating (rating, customer_CustomerID, product_productId)values (3,11,17);
insert into rating (rating, customer_CustomerID, product_productId)values (1,11,17);
insert into rating (rating, customer_CustomerID, product_productId)values (4,12,17);
insert into rating (rating, customer_CustomerID, product_productId)values (5,13,17);
insert into rating (rating, customer_CustomerID, product_productId)values (4,14,17);
insert into rating (rating, customer_CustomerID, product_productId)values (3,11,18);
insert into rating (rating, customer_CustomerID, product_productId)values (5,12,19);
insert into rating (rating, customer_CustomerID, product_productId)values (5,13,20);
insert into rating (rating, customer_CustomerID, product_productId)values (2,14,21);
insert into rating (rating, customer_CustomerID, product_productId)values (5,12,20);
insert into rating (rating, customer_CustomerID, product_productId)values (5,13,21);
insert into rating (rating, customer_CustomerID, product_productId)values (2,14,22);
insert into rating (rating, customer_CustomerID, product_productId)values (4,11,22);
select * from rating;
