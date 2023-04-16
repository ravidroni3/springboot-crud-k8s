FROM openjdk:11
EXPOSE 8080
ADD target/EmployeeCRUD.jar EmployeeCRUD.jar
ENTRYPOINT ["java","-jar", "EmployeeCRUD"]
