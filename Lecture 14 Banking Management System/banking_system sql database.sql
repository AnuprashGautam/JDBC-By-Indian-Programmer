CREATE DATABASE banking_system;
USE banking_system;

CREATE TABLE accounts(
	account_number BIGINT PRIMARY KEY NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    security_pin CHAR(4) NOT NULL
);

CREATE TABLE user(
	full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);
