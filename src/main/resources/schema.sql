DROP TABLE IF EXISTS Student;
CREATE TABLE Student(
    id int auto_increment primary key,
    name varchar(50) not null,
    department varchar(50) not null,
    college varchar(50) not null
);


DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
    id int auto_increment primary key,
    name varchar(50) not null,
    department varchar(50) not null,
    salary varchar(50) not null

)