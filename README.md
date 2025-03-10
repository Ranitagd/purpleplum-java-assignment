# purpleplum-java-assignment
Repository for Purpleplum Java assignment

This guide provides instructions to run the Java Spring Boot application with Maven, set up the MySQL database, and then run the APIs.

## Prerequisites

- **Java 11 or later** (Make sure you have the correct version installed by running `java -version`).
- **Maven** (Make sure Maven is installed and accessible via `mvn -v`).
- **MySQL** (Make sure MySQL is installed and running).
- **Postman** (Optional, for testing the APIs).
  
## Steps

### 1. Clone the Repository

Clone the project to your local machine:
    
        git clone <your-repository-url>
        cd <your-repository-directory>

#### 2. Configure MySQL Database

#### a. Create a Database in MySQL
1. Log into MySQL using the MySQL command line or MySQL Workbench:

    mysql -u root -p
   
2. Create a new database for the application and insert data into DB my using the purpleplum_customer.sql scripts.

#### 3. Configure application.properties for Spring Boot

	# MySQL Database Configuration
	spring.datasource.url=jdbc:mysql://localhost:3306/customer_db?useSSL=false&serverTimezone=UTC
	spring.datasource.username=root
	spring.datasource.password=<your-mysql-password>
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
	spring.jpa.show-sql=true

	# AES Secret Key for Encryption (16 bytes for AES-128)
	aes.secret.key=1234567890abcdef
	
#### 4. Build the Project Using Maven:
	mvn clean install

#### 5. Run the Spring Boot Application

#### 7. Implement Encryption and Decryption
	The customer’s customerIdentifierNumber field is sensitive information and is encrypted before storing it in the database.
	When the Get API is called the customerIdentifierNumber is descrypted back and returned.

#### 6. Test the APIs
	You can now test the APIs using Postman or directly via browser for simple GET requests.
	Base URL: http://localhost:8080/api/customers
	API Endpoints:
	POST /api/customers - Create a new customer.
	GET /api/customers?filter=johndoe@example.com&page=0&size=10&sortBy=customerName&sortDir=asc - Get all customers with pagination, sorting, and filtering.
	(filter query param accepts customer to be filtered by Country, State, Email)
	(sorting is asc by default if not provided)
	GET /api/customers/{id} - Get a customer by ID.
	GET /api/customers/decrypt/{id} - Get a customer by ID with Decrypted Identifier Numbeer.
	PUT /api/customers/{id} - Update a customer by ID.
	DELETE /api/customers/{id} - Delete a customer by ID.
	
#### 7. Testing with Postman
    
    Open Postman and import the provided Postman Collection purpleplum_customer.postman_collection.json.
    Base URL: http://localhost:8080/api/customers
	API Endpoints:
	POST /api/customers - Create a new customer.
	GET /api/customers?filter=johndoe@example.com&page=0&size=10&sortBy=customerName&sortDir=asc - Get all customers with pagination, sorting, and filtering.
	(filter query param accepts customer to be filtered by Country, State, Email)
	(sorting is asc by default if not provided)
	GET /api/customers/{id} - Get a customer by ID.
	GET /api/customers/decrypt/{id} - Get a customer by ID with Decrypted Identifier Numbeer.
	PUT /api/customers/{id} - Update a customer by ID.
	DELETE /api/customers/{id} - Delete a customer by ID.