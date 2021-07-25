"# jpmc" 
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)

# Runnig this project

1. Clone this project https://github.com/Nihar1993/jpmc  default branch is "main"
2. create databases schema in mysql - **jpmc**
3. edit **username** and **password** in **applicaton.properties** file
4. Run Project One time using Spring boot command - **mvn spring-boot:run** or using eclipse/intellij IDE run as Java Application
5. Run below Query in mysql
 
   #create table settlement (trader_id varchar(255) not null, amount decimal(19,2), currency varchar(255), message_id varchar(255), supporting_info varchar(255), value_daate datetime, primary key (trader_id))
   #create table receiver (trader_id varchar(255) not null, receiver_account_number varchar(255), receiver_bank_code varchar(255), primary key (trader_id))
  #create table payer (trader_id varchar(255) not null, payer_account_number varchar(255), payer_bank_code varchar(255), primary key (trader_id))

6. Then Again run project using boot 

### Guides

The https://spring.io/[spring.io] site contains several guides that show how to use Spring
Boot step-by-step:

- https://spring.io/guides/gs/spring-boot/ [Building an Application with Spring Boot] is a
  very basic guide that shows you how to create a simple application, run it and add some
  management services.
- https://spring.io/guides/gs/actuator-service/ [Building a RESTful Web Service with Spring
  Boot Actuator] is a guide to creating a REST web service and also shows how the server
  can be configured.
- https://spring.io/guides/gs/convert-jar-to-war/ [Converting a Spring Boot JAR Application
  to a WAR] shows you how to run applications in a web server as a WAR file.
  

### Assumption

1. For the given problem I designed three table  settlement,receiver and payer and created the mapping 
as one to one between settlement -> receiver and settlement -> payer because one settlement can have 
only one payer or receiver. 
2. I exposed two end points one is post for inserting the records to database and another is get for retrieving 
the record based on the tradeId.
 POST URL:  http://localhost:8080/api/asset-engine/message
   Request format for Post:
   {
   "tradeId":"16846548",
   "ssiCode":"OCBC_DBS_1",
   "amount":"12894.65",
   "currency":"USD",
   "valueDate": 20022020
   }
GET URL: http://localhost:8080/api/asset-engine/fetchSettlement/message?tradeId=16846548
   
I have defined all the constants as ENUM before inserting to database.

#Sorry did not get time for writing test cases 
