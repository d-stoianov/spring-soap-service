# Spring SOAP Service

This project is a small Java Spring SOAP API

## Requirements

- Java 21
- Maven

### Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/d-stoianov/spring-soap-service.git
   cd spring-soap-service
   ```

2. Install dependencies:

   ```
   mvn package
   ```

3. Build:

   ```
   mvn clean compile
   ```


4. Start the development server:

   ```
   mvn spring-boot:run
   ```

6. Test endpoints:

   ```
   cd test
   ```
   Test Good endpoint:
   ```
   curl --header "content-type: text/xml" -d @good.xml http://localhost:8080/ws
   ```
   Test Category endpoint:
   ```
   curl --header "content-type: text/xml" -d @category.xml http://localhost:8080/ws
   ```
