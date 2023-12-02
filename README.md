# PhoneShopService
The Phone Shop Service project is a web application that implements a RESTful API for managing mobile phone inventory in a phone store.
The application provides the ability to use CRUD operations on an object.

**Stack**: Java, Spring Boot, Spring AOP, Spring Data JPA, MapStruct, Log4j, Lombok, Jakarta Validation, JUnit, Mockito, PostgreSQL.

Additionally, the project has javadoc documentation describing how the application works.


## How To Use?
1. Create new database in PostgreSQL named `PhoneShopService`.
2. In created database add new user with username `postgres` and password `admin`.
3. Run this SQL script inside new database:
```
CREATE TABLE phone_shop (
    id SERIAL PRIMARY KEY,
    manufacturer VARCHAR(255),
    model VARCHAR(255),
    storage_size INT,
    color VARCHAR(255),
    cost INT,
    quantity INT
);
```
4. Launch the application using the PhoneShopApplication class.
