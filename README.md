# spring-data-redis-masterclass

## A good understanding of the usage of spring-data with REST Service and using Redis cache and Mongo as Database

### Software Required
* [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html)
* [Spring tool Suite](https://spring.io/tools) or [Eclipse](https://www.eclipse.org/downloads/packages/)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [Git Bash](https://git-scm.com/downloads)
* [Redis](https://redis.io/blog/install-redis-windows-11/)
* [Redis Insight](https://redis.io/insight/)
* [MongoDB](https://www.mongodb.com/try/download/community) - Download the Community Edition
* [Robo 3T](https://robomongo.org/download) - MongoDB Client. Download Robo 3T Only
* [Postman](https://www.postman.com/downloads/)

### Steps to clone and run the application
* Install Redis using Ubuntu provided in the [Redis](https://redis.io/blog/install-redis-windows-11/) link
* Verify Redis Installation by running the command as <code>redis-cli</code>
* Install Redis Insight that will act as the client to access Redis Cache
* Install MongoDb
* After installing, set the Environment Variable <strong>MONGO_HOME</strong>
* To verify open Command Prompt and type <code>mongod -version</code>
* Type <code>mongod</code> in the open terminal. It will run the daemon process of Mongo
* Open Git Bash or even you can open Command Prompt (if you are using Windows) or Terminal (if you are using MAC) in your machine
* Clone the application from github.com as   
<code>git clone https://github.com/c86amik/spring-data-redis-masterclass.git</code>
* Open either <strong>STS</strong> or <strong>Eclipse</strong> and import the application as <strong>Maven</strong> project
* After the application got successfully imported in either <strong>STS</strong> or <strong>Eclipse</strong>
* Right Click on the application, select the <strong>Run As</strong> option, and then select <strong>Spring Boot App</strong>
* The application will start in the port <strong>7123</strong>
* Open the Postman and test the REST Endpoints

### Testing using Postman
<ol>
<li><strong>Get All Employees</strong> - localhost:7123/allEmployees</li>
<li><strong>Get an Employee by ID</strong> - localhost:7123/getEmployee/{empId}. Here <strong>{empId}</strong> is the id of the record stored in MongoDB</li>
<li><strong>Save an Employee</strong> - localhost:7123/saveEmployee</li>
<li><strong>Update an Employee Details</strong> - localhost:7123/updateEmployee/{empId}. Here <strong>{empId}</strong> is the id of the record stored in MongoDB</li>
<li><strong>Delete an Employee</strong> - localhost:7123/deleteEmployee/{empId}. Here <strong>{empId}</strong> is the id of the record stored in MongoDB</li>
</ol>

#### Dummy JSON object
* Body for the <strong>POST</strong> Method   
<code>{
	"employeeId" : "EMP001",
	"panCard" : "ABCDE1234F",
	"empName" : "Test User 1"
}</code>
* Body for the <strong>PUT</strong> Method   
<code>{
	"employeeId" : "EMP001",
	"panCard" : "ABCDE1234F",
	"empName" : "Test User 1"
}</code>