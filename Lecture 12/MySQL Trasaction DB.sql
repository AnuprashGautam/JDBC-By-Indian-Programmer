CREATE DATABASE mydatabase;
USE mydatabase;

CREATE TABLE accounts(
account_number VARCHAR(20) PRIMARY KEY,
balance DECIMAL(10,2) NOT NULL
);

INSERT INTO accounts(account_number,balance) VALUES
("account123",1000.00),
("account456",500.00),
("account789",1500.00);