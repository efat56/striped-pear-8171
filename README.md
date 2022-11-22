# Online Shopping Application API 

 - We have developed this REST API for an Online Shopping Application. This API performs all the fundamental CRUD operations of any Online Shopping  Application platform with user validation at every step.
- This project is developed by team of 5 Back-End Developers during project week in Masai School.


## Entity Relationship Diagram
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/ERDiagram.jpg)



# Functionalities
-   User can register/login
-   See all products
-   Find products by category
-   Add to cart/edit into the cart
-   Place Order


## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-  Data Stored in the database(mySQL)
-  User Authentication of signUp and Login

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
    -   server.port=8088
    -   spring.datasource.url=jdbc:mysql://localhost:3306/shoppingdb
    -   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    -   spring.datasource.username=**Your UserName**
    -   spring.datasource.password=**YourPassword**
    -   spring.jpa.hibernate.ddl-auto=update
    -   spring.jpa.show-sql=true
    -   spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
    
-to check the swagger http://localhost:8088/swagger-ui/

# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Boot
-   Hibernate
-   MySQL
<p>
   <img src="https://img.icons8.com/color/64/000000/java.png"/>
   <img src="https://img.icons8.com/color/48/null/spring-logo.png"/>
   <img src="https://github.com/efat56/striped-pear-8171/blob/main/Images/hibernate_logo_icon_171004.png" />
   <img src="https://img.icons8.com/ios/50/null/mysql-logo.png"/>
</p>



# Team-Members
- [Efat Husneara](https://github.com/efat56)
- [Rupak Tyagi](https://github.com/Rupaktyagi)
- [Swapnil Vhantale](https://github.com/spvhantale)
- [Shameem A](https://github.com/shameemlatheef)
- [Aman Sharma](https://github.com/thesharmaa)

# Backend

## Swagger UI
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/AllController.png)

## Customer-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/CustomerController.png)

## Address-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/AddressController.png)

## Product-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/ProductController.png)

## Cart-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/CartController.png)

## OrderAndLogin-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/LoginAndOrderController.png)

## Error-Controller
![image](https://github.com/efat56/striped-pear-8171/blob/main/Images/ErrorController.png)


<p align="center"> <img src="https://64.media.tumblr.com/d0635fa4e4bf417b33f24bd481c21f88/tumblr_ppcabrYCWy1ue08b9o1_540.gif" alt="" /> </p>





