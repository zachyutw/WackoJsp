
DROP TABLE IF EXISTS LineItem;
DROP TABLE IF EXISTS OrderInfo;
DROP TABLE IF EXISTS ProductCatalog;
Drop TABLE IF EXISTS Customer;

Create table Customer
(
    customerId INT NOT NULL AUTO_INCREMENT,
    lastName VARCHAR(20),
    firstName VARCHAR(20),
    address VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(50),
    PRIMARY KEY(customerId)

);
Create table ProductCatalog(
    productId INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(10),
    color VARCHAR(10),
    size VARCHAR(10),
    price VARCHAR(10),
    PRIMARY KEY(productId)
);
Create table OrderInfo(
    orderId INT NOT NULL AUTO_INCREMENT,
    orderDate VARCHAR(50),
    orderTotal VARCHAR(50),
    customerId INT NOT NULL,
    PRIMARY KEY(orderId),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)

);
Create table LineItem(
    lineItemId INT NOT NULL AUTO_INCREMENT,
    qty INT,
    productId INT NOT NULL,
    orderId INT NOT NULL,
    PRIMARY KEY(lineItemId),
    FOREIGN KEY (productId) REFERENCES ProductCatalog(productId),
    FOREIGN KEY (orderId) REFERENCES OrderInfo(orderId)
    
);

INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (223,'b','a',1);
INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (224,'Klug','Bill',6044517148);
INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (225,'Klug','Bill',6044517148);
INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (226,'Klug','Bill',6044517148);
INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (227,'y','x',1);
INSERT INTO Customer (customerId, lastName, firstName, phone) VALUES (228,'y','x',1);

INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (1, 'Chair','green','small',10);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (2, 'Chair','green','medium',15);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (3, 'Chair','green','large',20);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (4, 'Chair','blue','small',10);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (5, 'Chair','blue','medium',15);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (6, 'Table','blue','large',20);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (7, 'Table','light','small',20);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (8, 'Table','light','medium',30);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (9, 'Table','dark','small',22);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (10, 'Table','dark','medium',32);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (11, 'Couch','green','medium',45);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (12, 'Couch','green','large',45);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (13, 'Couch','blue','medium',45);
INSERT INTO ProductCatalog (productId, type, color, size, price) VALUES (14, 'Couch','blue','small',45);

INSERT INTO OrderInfo (orderId, orderDate, orderTotal, customerId) VALUES (100, STR_TO_DATE('Wed Dec 09 17:55:23 2015','%a %b %d %T %Y'),0,223);
INSERT INTO OrderInfo (orderId, orderDate, orderTotal, customerId) VALUES (101, STR_TO_DATE('Wed Dec 28 09:56:57 2016','%a %b %d %T %Y'),0,224);
INSERT INTO OrderInfo (orderId, orderDate, orderTotal, customerId) VALUES (102, STR_TO_DATE('Wed Dec 28 09:59:19 2016','%a %b %d %T %Y'),0,224);
INSERT INTO OrderInfo (orderId, orderDate, orderTotal, customerId) VALUES (103, STR_TO_DATE('Wed Dec 28 13:36:56 2016','%a %b %d %T %Y'),0,224);
INSERT INTO OrderInfo (orderId, orderDate, orderTotal, customerId) VALUES (104, STR_TO_DATE('Wed Jan 04 14:55:39 2017','%a %b %d %T %Y'),0,227);

INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (152,1,1,100);
INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (153,1,1,101);
INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (154,1,1,102);
INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (155,1,1,103);
INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (156,1,2,103);
INSERT INTO LineItem (lineItemId, qty, productId, orderId) VALUES (157,1,1,104);








