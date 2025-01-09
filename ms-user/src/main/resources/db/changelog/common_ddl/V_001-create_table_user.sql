--liquibase formatted sql

-- changeset afranio:1
CREATE TABLE tb_user (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    phone_number VARCHAR(15) NOT NULL
);
