# Springboot-Userlogin
  It is a login history of the user Application. I used spring boot for this Application which takes REST API calls and provide appropriate response The front-end part using postman which takes usernameand password for logging into and stores the relative details in the Mongodb database at the backend. And the Login history of the user can be returned as JSON.  
 +
 +# Run Rest-services
 +under the root dir execute: gradlew bootRun this will run the server under the 8080 port
 +
 +# To list all the usernames the route is "/details"
 +
 +# save userlogins
 +to save a new username the route is "/savedetails" and the parameters are:
 +* username
 +* password
 +
 +example: use curl o postman (chrome extension) to test the rest service with a json document like this:
 +
 +```json
 +{
 +    "username": "ravi",
 +    "password": "password"
 +    
 +}
 +
 +```