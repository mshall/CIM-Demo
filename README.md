# CIM-Demo

- This repo is to apply the microservices architecture with different technologies used.
- There are 2 modules (**Customers & Complaints**)
- These modules resemble the relation between the customer and the normal operations to be done on & the complaints that the customer open.


# Repository content

- Accounts microervice (**Shall-CIM-Accounts**).
- Complaints microservice(**Shall-CIM-Complaints**).
- Complaints JSF frontend (**shall-cim-jsf**).
- Cutomers Angular 6 frontend (**Shall-CIM-Angular**)
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
- Angular 6
- RxJS 6
- jQuery
- Bootstrap
- 

## RESTful APIs collection:

[Postman collection](https://www.getpostman.com/collections/b9930f203975d983b7ed)

## Screenshot of result:

![enter image description here](https://picasaweb.google.com/115919670543409421172/6572865152440360225#6572865152467409266)


## How to run:

- Before running:
	-  **Accounts/Customers** microservice runs on port: 8081
	- **Complaints** microservice runs on port: **8082**
	- **JSF** project runs on port: **8080**
	- **Angular** project runs on port: **4200**
	- Final result page: Run it through the file system after everything is up with the name **main.html**

- for the Accounts , Complaints microservices & JSF project, run the following command 

> `mvn clean install package`

- Run the generated Jar files generated in target folders for the Accounts & Complaints microservice through the following commands:

> `java -jar 'Microservice_Name`

- Run the JSF project through deploying the war file on any server or within the Eclipse IDE

- Run the Angular project through the following command:
> `ng serve --open`


## Missing enhancements

- Addd another microservice: (**Spring-Config**) that will hold all of the configurations used by **Complaints** & **Customers** microservices in a centralized place
 - Add common jar between that contains the common classes and methods that are being used in both microservices
 - Add methods documentation
 - Add swagger for API documentation
 - Apply AOP for logging with integrating with Kafka in a **ULFF**
 - Apply the reactive programming concept regarding the communications between different microservices.
 

## Notes

- The work on this demo is not finished yet.
- Contact me: (mohamed.s.elshall2011@gmail.com)



