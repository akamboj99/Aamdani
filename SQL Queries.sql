1.  CREATE DATABASE AAMDANI


2.  Note : Create the following two tables in the above mentioned database.

    CREATE TABLE Student_Sign_Up
    (student_name VARCHAR(30),
    student_phone VARCHAR(10),
    student_email VARCHAR(30),
    student_password VARCHAR(10),
    student_confirm_password VARCHAR(10),
    student_specialization varchar(20),
    student_year INTEGER(1),
    student_sapid VARCHAR(9)
    student_degree VARCHAR(10),
    student_course VARCHAR(10));
    
	
    CREATE TABLE shopkeeper_sign_up
    (shopkeeper_name VARCHAR(20),
	shopkeeper_phone VARCHAR(10),
	shopkeeper_email VARCHAR(30),
	shopkeeper_password VARCHAR(20),
	shopkeeper_confirm_password VARCHAR(20),
	shopkeeper_shop_name varchar(30),
	shopkeeper_shop_address VARCHAR(100));


    create table jobs_posted
	(Job_No varchar(50),
    Email_Address varchar(50),
	Title varchar(100),
	Decription varchar(1000),
	Location varchar(20),
    Distance_From_UPES_In_KMs integer,
	Hourly_Stipend_INR integer,
	Start_Time varchar(10),
	End_Time varchar(10));
