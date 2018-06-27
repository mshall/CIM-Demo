# CIM-Demo

- This repo is to apply the microservices architecture with different technologies used.
- There are 2 modules (**Customers & Complaints**)
- These modules resemble the relation between the customer and the normal operations to be done on & the complaints that the customer open.


# Repository content

- Accounts microervice (**Shall-CIM-Accounts**).
- Complaints microservice(**Shall-CIM-Complaints**).
- Complaints JSF frontend (**shall-cim-jsf**).
- CIMCommons utility dependency (**To be added**)
- ULFF logger utility dependency (**To be added**)
- README.md file


## Technologies used

- Java 8
- Spring Boot
- Spring Data
- H2 in memory database
- RESTful Jackson
- Spring-Kafka integration

## RESTful APIs collection:

[Postman collection](https://www.getpostman.com/collections/b9930f203975d983b7ed)

## Missing enhancements

- Develop the **Angular5** user module
- Make navigation to the **Angular5** project in the **JSF project**
- Make navigation to the **JSF project** in the **Angular5** project
- Addd another microservice: (**Spring-Config**) that will hold all of the configurations used by **Complaints** & **Customers** microservices in a centralized place
 - Add common jar between that contains the common classes and methods that are being used in both microservices
 - Add methods documentation
 - Add swagger for API documentation
 - Apply AOP for logging with integrating with Kafka in a **ULFF**
 - Apply the reactive programming concept regarding the communications between different microservices.
 

## Notes

- The work on this demo is not finished yet.
- Contact me: (mohamed.s.elshall2011@gmail.com)



