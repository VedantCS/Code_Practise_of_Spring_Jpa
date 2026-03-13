
##  Spring Data JPA Practice Project

I did this after creating notes, which are publically available on the sprinboot notes repo 

This project demonstrates the implementation of **core Spring Data JPA concepts** through practical examples and test cases.

###  Key Concepts Implemented

* **Entity Relationships**

  * One-to-One
  * One-to-Many
  * Many-to-One
  * Many-to-Many
* **Pagination and Sorting**
* **Custom Queries using `@Query`**
* **Parameterized Queries using `@Param`**
* **Repository Testing**

These implementations showcase how to effectively manage relational data using **Spring Boot + Spring Data JPA**.

---

###  Project Structure

To explore the main implementation:

```
spring-data-jpa-practise
 └── src
     └── main
         └── java
             └── com
                 └── VedantCS
                     └── spring_data_jpa_practise
                         ├── entity
                         └── repository
```

* **entity** → Contains JPA entity classes demonstrating different relationships.
* **repository** → Contains Spring Data JPA repositories with custom queries and pagination examples.

---

###  Test Classes

Repository functionality and queries are verified using **repository test classes**, which demonstrate:

* CRUD operations
* Relationship handling
* Pagination
* Custom JPQL queries

---

###  Purpose of the Project

This repository serves as a **hands-on learning resource for Spring Data JPA**

---

