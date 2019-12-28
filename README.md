# Kotlin-SpringBoot2-JPA-Crud-RESTful
Integration Kotlin Spring boot 2 Spring Data JPA RESTful Web service, Crud Example

You can IDE Eclipse or IntelliJ Community. :)

Steps:

Execute next script on Mysql.

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) 


For test please use Postman.

GET

http://localhost:8080/ws/users

POST

http://localhost:8080/ws/users

json:

{
        "created": "2019-12-28T18:53:50.274+0000",
        "password": "123",
        "username": "henry"
 }
 
GET By Id user

http://localhost:8080/ws/users/1

PUT

http://localhost:8080/ws/users/1

json:

{
        "password": "hi123",
        "username": "tommyj"
 }

DELETE

http://localhost:8080/ws/users/1


