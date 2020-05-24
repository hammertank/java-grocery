# Spring Tricks
## Spring Boot Dependency Management with a Custom Parent
See [pom.xml](pom.xml)

## Handle URL with Too Many Params
See:
* [HttpMethodOverrideFilter](src/main/java/hammertank/grocery/spring/filter/HttpMethodOverrideFilter.java) 
* [EchoController](src/main/java/hammertank/grocery/spring/controller/EchoController.java).  

Provided example supports both requests:
* curl -X GET http://localhost:8080/echo?name=John
* curl -X POST -H "X-HTTP-Method-Override: GET" http://localhost:8080/echo -d "name=John"



## Convert JPA entity attribute into database column representation
See:
* [StringListConverter](src/main/java/hammertank/grocery/spring/jpa/converter/StringListConverter.java)
* [Employee](src/main/java/hammertank/grocery/spring/jpa/entity/Employee.java)
* [EmployeeDao](src/main/java/hammertank/grocery/spring/jpa/dao/EmployeeDao.java)
* [TestEmployeeDao](src/test/java/hammertank/grocery/spring/jpa/dao/TestEmployeeDao.java)