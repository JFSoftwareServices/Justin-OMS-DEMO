# Justin-OMS-DEMO

###Project setup
1. The base project is created using springboot starter kit Java 1.8 and Maven 
2. Database is H2 and please refer the application properties where you shall see spring.datasource.url=jdbc:h2:file:C:/DEMO/oms
3. You file system must have permission to create DB file in C:/DEMO/oms if not please change the location accordingly 

Note: You need to run (mvn build, mvn spring-boot:run or run from intelliJ / eclipse) the OmsApplication and then access the H2 database access http:localhost:8080/h2
spring.datasource.url=${DB_STORAGE:jdbc:h2:file:C:/DEMO/oms}
username=user
password=password

###Domain Driven Development (DDD) for Product : 
1. TDD : Product domain class with unit test
2. BDD : Product repository added along with service and test class
3. E2E : Product Controller RESTFUL Contract for CRUD operation with integration testing created  

### Running test for TDD, BDD and E2E
1. ProductTest - test case is created to use across the testing which can be enhanced due to timeline it is planned to keep it simple
2. ProductServiceTest - Service level test which will cover the repository to some extend - scope to add more tests
3. ProductControllerITTest - E2e test there is scope to clean up and enhance further, it is planned to keep simple with few issues to cover up all use cases

### End-point testing from postman
######1. Create Product : http://localhost:8080/api/v1/product
Method: POST
Payload: {
             "name": "Justinnew6",
             "price": 10.00,
         }
######2. Update Product : http://localhost:8080/api/v1/product/{id}
Method: PUT
Payload: {
             "name": "Justinnew7",
             "price": 10.00,
         }

######3. Get All Products : http://localhost:8080/api/v1/products
Method: GET
Payload: Not required

######4. Delete Product (soft delete) : http://localhost:8080/api/v1/product/{id}
Method: DELETE 
Payload: Not required

##Order flow will be demonstrated without any testing as the above example covers the required skill-set 

1. DDD - Order and Order Line domain object without any TDD and BDD, order total calculation 
Note: Order total calculation is order domain responsibility hence it is delegated to this domain class  
2. Repository and Service to show case the required order range flow search and relationship mapping
3. End to end manual testing using postman

### End-point testing from postman
######1. Create Order : http://localhost:8080/api/v1/order
Method: POST
Payload: {
             "buyerEmailId" : "justin@justin.com",
             "orderLines" : [{ 
             "product" : {
                 "id": 1,
                 "name": "Justinnew1",
                 "price": 10.00        
             }
             }
         ]
         }

######2. Get All Orders for past X days (due to timeline it is simplified) : http://localhost:8080/api/v1/orders/5
Note: In this example the 5 is mapped to X and current date - X days order can be fetched using this API 
Method: GET
Payload: Not required