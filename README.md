# Master Management 📚
Application web developed in Spring with language Java, allows master management of a university implementing different functionalities

## Built with 🛠️
* [Maven](https://maven.apache.org/) - Dependency handler 
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - JDK17 Java ♨️
* [Spring Boot](https://spring.io/) - Framework
* [MySQL](https://www.mysql.com/) - Database

## Dependencies 👻
* ModelMapper (Version 3.0.0)
* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* Spring Boot DevTools
* Lombok
* MySQL Connector Java
* Spring Boot Starter Validation


## Functionalities ✅

* ### Student : 
    ➡️  Create a student\
    ➡️  Find all students\
    ➡️  Find a student by Id\
    ➡️  Update a student\
    ➡️  Delete a student by Id\
    ➡️  Find students by name or lastname or email (contains)

* ### Teacher : 
    ➡️  Create a teacher\
    ➡️  Find all teachers

* ### Course : 
    ➡️  Create a course\
    ➡️  Find all courses\
    ➡️  Find a course by Id\
    ➡️  Delete a course by Id

* ### Subject : 
    ➡️  Create a subject\
    ➡️  Find all subjects\
    ➡️  Find a subject by Id

## Validations 👁‍🗨

* ### Student : 
    💎 Id can't be negative\
    💎 Identification can't be empty\
    💎 Identification can't be null\
    💎 The number of characters' name must be between 3 and 50\
    💎 Name can't be null\
    💎 The number of characters' lastname must be between 3 and 50\
    💎 Lastname can't be null\
    💎 Date can't be in the future\
    💎 Email can't be repetead

* ### Teacher : 
    💎 Id can't be negative\
    💎 Identification can't be empty\
    💎 Identification can't be null\
    💎 The number of characters' name must be between 3 and 50\
    💎 Name can't be null\
    💎 The number of characters' lastname must be between 3 and 50\
    💎 Lastname can't be null\
    💎 Salary must be a positive number

* ### Course : 
    💎 The number of characters' course name must be between 5 and 25\
    💎 Period must be a value between 1 and 2


* ### Subject : 
    💎 The number of characters' subject name must be between 5 and 25

* ### Address : 
    💎 The number of characters' address must be between 5 and 25

* ### Telephone : 
    💎 The number of characters' telephone must be between 5 and 25 y must start with 8

## Run and build 🚀
---
### Follow the next steps :  
1. *Clone the repository :*
```
    git clone https://github.com/sebart7/master-management.git
```
2. *Create a database with name and configure application.properties:*
```
    mastermanagement
```
3. *Build :*
```
    mvn clean install package
```
4. *Execute :*
```
    mvn exec:java -Dexec.mainClass="com.mastermanagement.mastermanagement.CoreApplication"
```