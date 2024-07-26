spring boot application maintains employees records in spring boot in built memory and exposes CURD operation using REST API and GRPC endpoints.

**PREREQUISITES:**

‣ JAVA 17

‣ MAVEN 3

‣ SPRING BOOT 3

‣ DOCKER

This spring boot application maintain employees records in H2 DB and exposes endpoints like get all employees , get Employee , create and delete in both REST API and GRPC format. 

PROTO FILE: [employee.proto](src/main/resources/protofiles/employee.proto)

REST API: [EmployeeController](src/main/java/com/partheeban/component/controller/EmployeeController.java)

REST API uses port 8081 and GRPC uses port 9090. These ports can be modified in the corresponding properties in properties file. 

SWAGGER LINK: http://localhost:8081/swagger-ui/index.html#/

Use maven clean install command to generate Mapper, grpc classes and jar file.  

    mvn clean install

DOCKER COMMANDS:

To build docker image:

    docker build -t my-spring-boot-app .

To start docker container:

    docker run -p -d 8081:8081 -p 9090:9090 my-spring-boot-app
