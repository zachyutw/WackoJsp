Author: Zach Yu, Andrew Hampson
Date: Feb 28 2017
Project: Wacko company’s product order website use jsp
Design Principle: Follow MVC architecture 

Complete percentage: 100%

Face Issues: 
1. Can't use Microsoft Access on my Mac laptop 
2. Can't download the Microsoft Access from school because dream spark have some problems

Solutions:
1.Database type Change from MicroSoft Access to Mysql
    a. install mysql
    b. create database
    c. create tables use WackoTables.sql script
    d. put the connecter mysql-connector-java-5.1.40-bin.jar to Tomcat lib directory
    e. Change the Driver to "com.mysql.jdbc.Driver" 
    f. Change the Driver Url to "jdbc:mysql://127.0.0.1:3306/Wacko?user=root&password=password"

Improvements: 
    1. Build some useful methods in the Database.java for searching data
    2. Create a function for refill Order
    
Problems:
    Can't forbid users click previous page after they submit the form. 
    If users go back to last page, the database would receive data twice.