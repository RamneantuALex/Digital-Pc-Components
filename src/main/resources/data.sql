DROP TABLE IF EXISTS Review;
DROP TABLE IF EXISTS ServiceRequest;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Basket;
DROP TABLE IF EXISTS ProductDiscount;
DROP TABLE IF EXISTS ElectronicSystem;
DROP TABLE IF EXISTS User;

CREATE TABLE User
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName  VARCHAR(50),
    email     VARCHAR(100) UNIQUE,
    password  VARCHAR(100),
    role      ENUM ('JUNIOR_SWE', 'SENIOR_SWE', 'CLIENT', 'MANAGER')
);

CREATE TABLE ElectronicSystem
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    price       DECIMAL(10, 2),
    description TEXT,
    promotion   BOOLEAN,
    stock       INT,
    review      TEXT,
    systemType  ENUM ('DESKTOP_PC', 'LAPTOP_PC', 'PRINTER', 'PERIPHERAL', 'COMPONENT')
);

CREATE TABLE Basket
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    clientId  INT,
    productId INT,
    quantity  INT,
    FOREIGN KEY (clientId) REFERENCES User (id),
    FOREIGN KEY (productId) REFERENCES ElectronicSystem (id)
);

CREATE TABLE Orders
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    clientId  INT,
    productId INT,
    quantity  INT,
    orderDate DATETIME,
    status    ENUM ('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED'),
    FOREIGN KEY (clientId) REFERENCES User (id),
    FOREIGN KEY (productId) REFERENCES ElectronicSystem (id)
);

CREATE TABLE ServiceRequest
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    clientId    INT,
    serviceDate DATETIME,
    status      ENUM ('SCHEDULED', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED'),
    FOREIGN KEY (clientId) REFERENCES User (id)
);

CREATE TABLE Review
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    clientId   INT,
    productId  INT,
    rating     INT CHECK (rating >= 1 AND rating <= 5),
    comment    TEXT,
    reviewDate DATETIME,
    FOREIGN KEY (clientId) REFERENCES User (id),
    FOREIGN KEY (productId) REFERENCES ElectronicSystem (id)
);

CREATE TABLE ProductDiscount
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    productId INT,
    discount  DECIMAL(5, 2),
    startDate DATETIME,
    endDate   DATETIME,
    FOREIGN KEY (productId) REFERENCES ElectronicSystem (id)
);

INSERT INTO User (firstName, lastName, email, password, role)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password123', 'CLIENT'),
       ('Jane', 'Smith', 'jane.smith@example.com', 'password123', 'JUNIOR_SWE'),
       ('Alice', 'Johnson', 'alice.johnson@example.com', 'password123', 'SENIOR_SWE'),
       ('Bob', 'Brown', 'bob.brown@example.com', 'password123', 'MANAGER'),
       ('Emily', 'Davis', 'emily.davis@example.com', 'password123', 'CLIENT'),
       ('Michael', 'Wilson', 'michael.wilson@example.com', 'password123', 'CLIENT'),
       ('Sarah', 'Taylor', 'sarah.taylor@example.com', 'password123', 'CLIENT');

INSERT INTO ElectronicSystem (price, description, promotion, stock, review, systemType)
VALUES (999.99, 'High-end Desktop PC', false, 10, 'Great performance for gaming and productivity', 'DESKTOP_PC'),
       (499.99, 'Affordable Laptop PC', true, 20, 'Good value for money', 'LAPTOP_PC'),
       (150.00, 'All-in-One Printer', false, 15, 'Prints, scans, and copies efficiently', 'PRINTER'),
       (25.00, 'Wireless Mouse', true, 50, 'Comfortable and responsive', 'PERIPHERAL'),
       (100.00, '16GB DDR4 RAM', false, 30, 'High-speed memory for your PC', 'COMPONENT'),
       (799.99, 'Gaming Laptop', true, 10, 'Ultimate gaming performance on the go', 'LAPTOP_PC'),
       (399.99, 'Wireless Keyboard', false, 25, 'Convenient and stylish', 'PERIPHERAL'),
       (299.99, '24-inch Monitor', true, 20, 'Crisp and clear display', 'PERIPHERAL'),
       (149.99, 'Bluetooth Speaker', false, 30, 'Rich sound quality', 'PERIPHERAL'),
       (199.99, 'External Hard Drive', true, 15, 'Securely store your data', 'PERIPHERAL');

INSERT INTO Basket (clientId, productId, quantity)
VALUES (1, 1, 1),
       (1, 4, 2),
       (3, 2, 1),
       (4, 5, 1),
       (5, 3, 1);

INSERT INTO Orders (clientId, productId, quantity, orderDate, status)
VALUES (1, 1, 1, '2024-05-01 10:00:00', 'PENDING'),
       (1, 2, 1, '2024-05-02 11:00:00', 'SHIPPED'),
       (1, 4, 2, '2024-05-03 12:00:00', 'DELIVERED'),
       (3, 3, 1, '2024-05-04 13:00:00', 'PENDING'),
       (4, 5, 1, '2024-05-05 14:00:00', 'SHIPPED');

INSERT INTO ServiceRequest (clientId, serviceDate, status)
VALUES (1, '2024-05-10 09:00:00', 'SCHEDULED'),
       (1, '2024-05-11 10:00:00', 'IN_PROGRESS'),
       (2, '2024-05-12 11:00:00', 'SCHEDULED'),
       (3, '2024-05-13 12:00:00', 'IN_PROGRESS'),
       (4, '2024-05-14 13:00:00', 'SCHEDULED');

INSERT INTO Review (clientId, productId, rating, comment, reviewDate)
VALUES (1, 1, 5, 'Excellent performance!', '2024-05-05 14:00:00'),
       (1, 2, 4, 'Good value for the price', '2024-05-06 15:00:00'),
       (1, 4, 4, 'Works well, very responsive', '2024-05-07 16:00:00'),
       (2, 3, 5, 'Great printer, easy to use', '2024-05-08 17:00:00'),
       (3, 5, 4, 'Good quality RAM, fast shipping', '2024-05-09 18:00:00');

INSERT INTO ProductDiscount (productId, discount, startDate, endDate)
VALUES (2, 10.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59'),
       (4, 5.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59'),
       (6, 15.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59'),
       (7, 15.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59'),
       (8, 8.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59'),
       (10, 20.00, '2024-05-01 00:00:00', '2024-05-31 23:59:59');
