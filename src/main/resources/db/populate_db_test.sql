DELETE FROM purchase;
ALTER TABLE purchase ALTER COLUMN id RESTART WITH 0;

--  DROP SEQUENCE global_seq RESTRICT;
--  CREATE SEQUENCE global_seq AS BIGINT START WITH 0;

DELETE FROM USERS;
INSERT INTO USERS(name, email, created_date)VALUES('John', 'john@apple.com',CURRENT TIMESTAMP);
INSERT INTO USERS(name, email, created_date)VALUES('Bob', 'bob@apple.com',CURRENT TIMESTAMP);
INSERT INTO USERS(name, email, created_date)VALUES('Anna', 'anna@apple.com',CURRENT TIMESTAMP);
INSERT INTO USERS(name, email, created_date)VALUES('Olga', 'olga@apple.com',CURRENT TIMESTAMP);