**Overview**

The PetStore REST Assured Automation Project is an API automation framework designed to validate the PetStore API endpoints. The project leverages REST Assured for API testing with
BDD-style syntax and provides robust testing coverage for user, pet, and store modules. This framework uses POJO classes for request payload, and TestNG for managing tests 
and generating reports.

**Features**

1.User, Pet, Store Modules:
  
Automated API testing for each module (User, Pet, Store) with CRUD operations.

**User Module:**

The User module handles operations related to user management.

POST /user (postUser): Creates a new user.

GET /user/{username} (getUser): Retrieves details of an existing user.

PUT /user/{username} (updateUser): Updates an existing user’s details.

DELETE /user/{username} (deleteUser): Deletes a user from the system.

**Pet Module:**

The Pet module manages pet information and operations.

GET /pet/{petId} (getPet): Fetches details of a specific pet.

POST /pet (addPet): Adds a new pet to the store.

PUT /pet (updatePet): Updates information for an existing pet.

DELETE /pet/{petId} (deletePet): Removes a pet from the store.

**Store Module:**

The Store module is responsible for order management.

POST /store/order (createOrder): Creates an order for a pet.

GET /store/order/{orderId} (getOrder): Retrieves an order using its ID.

DELETE /store/order/{orderId} (deleteOrder): Deletes an order from the system.

2.Data-Driven Testing:

Data fetching from Excel and JSON schema validation.

3.Request/Response Validation:

Status code validation, response body assertions, and JSON schema checks.

4.Test Execution:

Parallel test execution using TestNG and DataProviders.

5.Reporting:

ExtentReports for visual test reports and TestNG HTML reports.

**Technologies Used**

Programming Language: Java

API Testing Framework: REST Assured

Test Framework: TestNG

Build Tool: Maven

Data Management: Excel, JSON

Reporting: Extent Reports

Version Control: Git,Github

**Folder Structure**

PetStoreAutomation/

├── src/

│   ├── test/

│   │   ├── java/

│   │   │   ├── endpoints/          # API endpoint classes (User, Pet, Store)

│   │   │   │   ├── Base.java       # Base class with URL and endpoints

│   │   │   │   ├── UserEndPoints.java

│   │   │   │   ├── PetEndPoints.java

│   │   │   │   └── StoreEndPoints.java

│   │   │   ├── payload/            # POJO classes for request payload

│   │   │   │   ├── UserPayload.java

│   │   │   │   ├── PetPayload.java

│   │   │   │   └── StorePayload.java

│   │   │   ├── test/               # Test classes

│   │   │   │   ├── UserTests.java  # CRUD tests for User

│   │   │   │   ├── PetTests.java   # CRUD tests for Pet

│   │   │   │   ├── StoreTests.java # CRUD tests for Store

│   │   │   │   └── DataDrivenTests.java # Data-driven tests

│   │   │   ├── utilities/          # Utility classes

│   │   │   │   ├── Dataproviders.java

│   │   │   │   ├── ExcelUtility.java

│   │   │   │   └── ExtentReport.java

├── src/

│   ├── test/

│   │   ├── resources/              # Resource files

│   │   │   ├── userdataSchema.json  # JSON schema for User data

│   │   │   ├── petdataSchema.json   # JSON schema for Pet data

│   │   │   ├── storedataSchema.json # JSON schema for Store data

│   │   │   └── URL.properties       # URL properties for modules

├── reports/                        # Generated Extent reports

├── testData/                       # Test data files (e.g., Petstore userdata.xlsx)

├── test-output/                    # TestNG HTML reports

├── pom.xml                         # Maven dependencies and configurations

└── testng.xml                      # TestNG suite configuration

**Report Screenshots**

**Report1**

![PetStore ss1](PetStore%20screenshots/PetStore%20ss1.PNG)

**Report2**

![PetStore ss2](PetStore%20screenshots/PetStore%20ss2.PNG)













