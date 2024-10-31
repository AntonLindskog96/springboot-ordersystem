# Order Management System

Detta projekt är ett RESTful API för hantering av beställningar, byggt med Java och Spring Boot. Det implementerar ett CRUD-system för ordrar och använder PostgreSQL som databashanteringssystem, tillsammans med Spring Data JPA och Hibernate för ORM. För att logga orderhistorik används MongoDB, vilket möjliggör flexibel hantering av historiska data. Meddelanden mellan systemets olika delar hanteras med JMS och ActiveMQ som meddelandekö.
## Teknologier
Projektet är byggt med följande teknologier:
- **Java 17**: Programmeringsspråket som används för att utveckla applikationen.
- **Spring Boot**: Används för att skapa en stand-alone applikation med inbäddad server och färdiga konfigureringar.
- **Spring Data JPA**: Tillhandahåller integration med JPA för dataåtkomst och ORM.
- **Hibernate**: En ORM-ramverk som används för att mappa objekt till databasen.
- **PostgreSQL**: Databashanteringssystem som används för lagring av applikationens data.
- **MongoDB**: För att lagra och hantera OrderHistory (historik över ordrar) används MongoDB.
- **Maven**: Byggverktyg som hanterar beroenden och projektstruktur.
- **JMS**: Används för att skicka meddelanden mellan olika delar av applikationen.
- **ActiveMQ**: En meddelandekö som implementerar JMS, vilket gör det möjligt att skicka och ta emot meddelanden asynkront.

- **React Typescript**:Används för att bygga frontend-applikationen.

## Funktioner
API:et erbjuder följande funktioner för hantering av ordrar:
- **Skapa en ny order**: Lägg till en ny order i databasen.
- **Hämta alla ordrar**: Visa alla ordrar i systemet.
- **Hämta en enskild order**: Hämta detaljer för en specifik order baserat på dess ID.
- **Uppdatera en order**: Ändra information om en existerande order.
- **Ta bort en order**: Ta bort en specifik order från databasen.



