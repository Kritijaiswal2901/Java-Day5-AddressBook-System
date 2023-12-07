-- UC1
-- creating new database for address books
create database address_book_service;
show databases;
+---------------------+
| Database            |
+---------------------+
| address_book_system |
| information_schema  |
| mysql               |
| performance_schema  |
| sys                 |
+---------------------+
5 rows in set (0.00 sec)

-- UC2
-- using the created database
USE address_book_service;

-- creating an address book table
CREATE TABLE addressBook1 (
    first_name varchar(50) not null,
    last_name varchar(50),
    address varchar(100),
    city varchar(20),
    state varchar(20),
    zip varchar(10),
    phone varchar(20), 
    email varchar(320)
);

-- UC3
-- creating new contacts in address book
INSERT INTO addressBook1 (first_name, last_name, address, city, state, zip, phone, email) VALUES
	("Kriti", "Jaiswal", "Hazipur", "Patna", "Bihar", "74185", "919936574857", "kritijaiswal7485@gmail.com"),
    ("Sandhya", "Sharma", "Campel Road", "Amritsar", "Punjab", "456002", "91 9685741452", "sandhyasharma47@gmail.com");


SELECT * FROM addressBook1;
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
| first_name | last_name | address     | city     | state  | zip    | phone         | email                      |
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
| Kriti      | Jaiswal   | Hazipur     | Patna    | Bihar  | 74185  | 919936574857  | kritijaiswal7485@gmail.com |
| Sandhya    | Sharma    | Campel Road | Amritsar | Punjab | 456002 | 91 9685741452 | sandhyasharma47@gmail.com  |
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
2 rows in set (0.00 sec)


-- UC4
-- editing the contact using first name
UPDATE addressBook1 SET address = "Kochi" where first_name = "Kriti";


SELECT * FROM addressBook1;
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
| first_name | last_name | address     | city     | state  | zip    | phone         | email                      |
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
| Kriti      | Jaiswal   | Kochi       | Patna    | Bihar  | 74185  | 919936574857  | kritijaiswal7485@gmail.com |
| Sandhya    | Sharma    | Campel Road | Amritsar | Punjab | 456002 | 91 9685741452 | sandhyasharma47@gmail.com  |
+------------+-----------+-------------+----------+--------+--------+---------------+----------------------------+
2 rows in set (0.00 sec)

-- UC5
-- deleting a contact using first_name
DELETE FROM addressBook1 WHERE first_name = "Sandhya";

SELECT * FROM addressBook1;
+------------+-----------+---------+-------+-------+-------+--------------+----------------------------+
| first_name | last_name | address | city  | state | zip   | phone        | email                      |
+------------+-----------+---------+-------+-------+-------+--------------+----------------------------+
| Kriti      | Jaiswal   | Kochi   | Patna | Bihar | 74185 | 919936574857 | kritijaiswal7485@gmail.com |
+------------+-----------+---------+-------+-------+-------+--------------+----------------------------+
1 row in set (0.00 sec)

-- adding more data to table
INSERT INTO addressBook1 (first_name, last_name, address, city, state, zip, phone, email) VALUES
	("Anju", "Sharma", "Danapur", "Patna", "Bihar", "784575", "91 9876542581", "anju0174@gmail.com"),
    ("Ishika", "Das", "Adampur", "Patna", "Bihar", "784572", "91 9871473698", "ishika7875@gmail.com");

-- UC6
-- retrieving people belonging to city
SELECT * FROM addressBook1 WHERE city = "Patna";
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| first_name | last_name | address | city  | state | zip    | phone         | email                      |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| Kriti      | Jaiswal   | Kochi   | Patna | Bihar | 74185  | 919936574857  | kritijaiswal7485@gmail.com |
| Anju       | Sharma    | Danapur | Patna | Bihar | 784575 | 91 9876542581 | anju0174@gmail.com         |
| Ishika     | Das       | Adampur | Patna | Bihar | 784572 | 91 9871473698 | ishika7875@gmail.com       |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
3 rows in set (0.00 sec)

-- retrieving people belonging to state
SELECT * FROM addressBook1 WHERE state = "Bihar";
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| first_name | last_name | address | city  | state | zip    | phone         | email                      |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| Kriti      | Jaiswal   | Kochi   | Patna | Bihar | 74185  | 919936574857  | kritijaiswal7485@gmail.com |
| Anju       | Sharma    | Danapur | Patna | Bihar | 784575 | 91 9876542581 | anju0174@gmail.com         |
| Ishika     | Das       | Adampur | Patna | Bihar | 784572 | 91 9871473698 | ishika7875@gmail.com       |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
3 rows in set (0.00 sec)

-- UC7
-- getting number of contacts by each city
SELECT city, count(city) FROM addressBook1 GROUP BY city;
+-------+-------------+
| city  | count(city) |
+-------+-------------+
| Patna |           3 |
+-------+-------------+
1 row in set (0.01 sec)

-- getting number of contacts by every state
SELECT state, count(state) FROM addressBook1 GROUP BY state;
+-------+--------------+
| state | count(state) |
+-------+--------------+
| Bihar |            3 |
+-------+--------------+
1 row in set (0.00 sec)

-- UC8
-- retrieve entries sorted by name for particular city
SELECT * FROM addressBook1 WHERE city = "Patna" ORDER BY first_name ASC;
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| first_name | last_name | address | city  | state | zip    | phone         | email                      |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
| Anju       | Sharma    | Danapur | Patna | Bihar | 784575 | 91 9876542581 | anju0174@gmail.com         |
| Ishika     | Das       | Adampur | Patna | Bihar | 784572 | 91 9871473698 | ishika7875@gmail.com       |
| Kriti      | Jaiswal   | Kochi   | Patna | Bihar | 74185  | 919936574857  | kritijaiswal7485@gmail.com |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+
3 rows in set (0.00 sec)

-- UC 9
-- adding name and type to address book
ALTER TABLE addressBook1 ADD column type varchar(20), ADD column name varchar(50);

-- adding name and type to all contacts
UPDATE addressBook1 SET name = "book1";
UPDATE addressBook1 SET type = "friends" WHERE first_name IN ("Ishika", "Anju");
UPDATE addressBook1 SET type = "family" WHERE first_name IN ("Kriti");


SELECT * FROM addressBook1;
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+---------+-------+
| first_name | last_name | address | city  | state | zip    | phone         | email                      | type    | name  |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+---------+-------+
| Kriti      | Jaiswal   | Kochi   | Patna | Bihar | 74185  | 919936574857  | kritijaiswal7485@gmail.com | family  | book1 |
| Anju       | Sharma    | Danapur | Patna | Bihar | 784575 | 91 9876542581 | anju0174@gmail.com         | friends | book1 |
| Ishika     | Das       | Adampur | Patna | Bihar | 784572 | 91 9871473698 | ishika7875@gmail.com       | friends | book1 |
+------------+-----------+---------+-------+-------+--------+---------------+----------------------------+---------+-------+
3 rows in set (0.00 sec)

-- UC10
-- get number of contacts by type
SELECT type, count(type) FROM addressBook1 GROUP BY type;
+---------+-------------+
| type    | count(type) |
+---------+-------------+
| family  |           1 |
| friends |           2 |
+---------+-------------+
2 rows in set (0.00 sec)

-- UC11
-- add contact to both friends and family
INSERT INTO addressBook1 (first_name, last_name, address, city, state, zip, phone, email, type, name) VALUES
	("Sakshi", "Singh", "Danapur", "Patna", "Bihar", "784575", "91 9872583694", "sakshisingh017@gmail.com", "friends", "book1"),
    ("Palak", "Jain", "Indira Nagar", "Lucknow", "UP", "508755", "91 6392099360", "palakjain2574@gmail.com", "family", "book1");


SELECT * FROM addressBook1;
+------------+-----------+--------------+---------+-------+--------+---------------+----------------------------+---------+-------+
| first_name | last_name | address      | city    | state | zip    | phone         | email                      | type    | name  |
+------------+-----------+--------------+---------+-------+--------+---------------+----------------------------+---------+-------+
| Kriti      | Jaiswal   | Kochi        | Patna   | Bihar | 74185  | 919936574857  | kritijaiswal7485@gmail.com | family  | book1 |
| Anju       | Sharma    | Danapur      | Patna   | Bihar | 784575 | 91 9876542581 | anju0174@gmail.com         | friends | book1 |
| Ishika     | Das       | Adampur      | Patna   | Bihar | 784572 | 91 9871473698 | ishika7875@gmail.com       | friends | book1 |
| Sakshi     | Singh     | Danapur      | Patna   | Bihar | 784575 | 91 9872583694 | sakshisingh017@gmail.com   | friends | book1 |
| Palak      | Jain      | Indira Nagar | Lucknow | UP    | 508755 | 91 6392099360 | palakjain2574@gmail.com    | family  | book1 |
+------------+-----------+--------------+---------+-------+--------+---------------+----------------------------+---------+-------+
5 rows in set (0.00 sec)